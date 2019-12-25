package Lessons.Task3.Task2.Filter;

public class EndStringFilter extends StringFilter implements Filter  {

    public EndStringFilter(String pattern) {
        super(pattern);
    }

    @Override
    public boolean apply(String applicationString) {
        return applicationString.endsWith(super.getPattern());
    }
}
