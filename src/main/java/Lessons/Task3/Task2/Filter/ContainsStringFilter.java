package Lessons.Task3.Task2.Filter;

import java.util.regex.Pattern;

public class ContainsStringFilter extends StringFilter implements Filter {

    public ContainsStringFilter(String pattern){
        super(pattern);
    }

    @Override
    public boolean apply(String applicationString) {
        return Pattern.compile("\\Q" + super.getPattern() + "\\E").matcher(applicationString).find();
    }
}
