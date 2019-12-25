package Lessons.Task3.Task2.Filter;

abstract class StringFilter implements Filter {
    private String pattern;

    public StringFilter(String pattern){
        setPattern(pattern);
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        if(pattern == null || pattern.equals("")){
            throw new IllegalArgumentException("String can't be null");
        } else {
            this.pattern = pattern;
        }
    }
}
