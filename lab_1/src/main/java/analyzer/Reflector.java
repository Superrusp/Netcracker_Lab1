package analyzer;

import fillers.Filler;
import fillers.Generator;
import org.reflections.Reflections;
import sorters.Sorter;
import sorters.abstraction.AbstractSorter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Set;

/**
 * The class <b>Reflector</b> is used to research methods
 * and objects using reflection.
 * <p> It allows to add new methods from class <b>Filler</b>
 * or objects of new subclasses of class <b>AbstractSorter</b> dynamically
 *
 * @author Amir Dogmosh
 */
public class Reflector {

    /**
     * This method allows to get all subclasses
     * of class <b>AbstractSorter</b> using reflection.
     * @return the collection of subclasses.
     */
    private Set<Class<? extends AbstractSorter>> getSubClasses() {
        Reflections reflections = new Reflections("sorters");
        Set<Class<? extends AbstractSorter>> set = reflections.getSubTypesOf(AbstractSorter.class);
        removeAbstractClasses(set);
        return set;
    }

    /**
     * This method is used to remove abstract classes from collection.
     *
     * @param subClasses the collection of objects of class <b>AbstractSorter</b>.
     */
    private void removeAbstractClasses(Set<Class<? extends AbstractSorter>> subClasses) {
        subClasses.removeIf(c -> Modifier.isAbstract(c.getModifiers()));
    }

    /**
     * This method is used to get all methods of class <b>Fillers</b>
     * that marked annotation {@link Generator}.
     *
     * @param fillers presents a collection of methods,
     *                that will be called to fill the array.
     * @see Analyzer#analyzeSorters(int).
     */
    public Set<Method> getFillers(Set<Method> fillers) {
        Method[] methods = Filler.class.getMethods();
        for (Method m : methods) {
            if (m.isAnnotationPresent(Generator.class)) {
                fillers.add(m);
            }
        }
        return fillers;
    }

    /**
     * This method allows to get objects of inherited classes using reflection.
     *
     * @param sorters the collection of objects, which contains subclasses of class <b>AbstractSorter</b>.
     * @return the collection that will be used to call {@link AbstractSorter#sort(int[])}method.
     * @see Analyzer#analyzeSorters(int).
     */
    public Set<AbstractSorter> getObjects(Set<AbstractSorter> sorters) {
        for (Class<? extends AbstractSorter> sorter : getSubClasses()) {
            try {
                Constructor<? extends AbstractSorter> constructor = sorter.getConstructor();
                AbstractSorter o = constructor.newInstance();
                sorters.add(o);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
                e.printStackTrace();
            }
        }
        return sorters;
    }

    /**
     * This method returns annotation's name which is marked on the method.
     * @param method the method is used to find its name using annotation.
     */
    public String getFillerName(Method method){
        Generator generator = method.getAnnotation(Generator.class);
        return generator.name();
    }

    /**
     * This method returns annotation's name which marked on the class.
     * @param abstractSorter the object is used to find its name using annotation.
     */
    public String getSorterName(AbstractSorter abstractSorter){
        Sorter sorter = abstractSorter.getClass().getAnnotation(Sorter.class);
        return sorter.sorterName();
    }
}
