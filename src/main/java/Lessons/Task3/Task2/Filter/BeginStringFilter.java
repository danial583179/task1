package Lessons.Task3.Task2.Filter;

public class BeginStringFilter extends StringFilter implements Filter {

    public  BeginStringFilter(String pattern){
        super(pattern);
    }

    @Override
    public boolean apply(String applicationString) {
        return applicationString.startsWith(super.getPattern());
    }
}
