import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class RegExTester {
public static void main(String[] args) {
    doRegExMatch("dfa|nfa", Pattern.CASE_INSENSITIVE,
        " DFAs are cool, but NFAs are easier to design.");


    doRegExMatch("\\d+", 0,
        "The numbers are 3 cats, 45 dogs, and -7 birds, but 12345 total animals.");

    doRegExMatch("-\\d+", 0,
        "The train traveled towrad the tall tower today.");

    doRegExMatch("\\bt\\w*", Pattern.CASE_INSENSITIVE,
        "The train traveled toward the tall tower today.");

    doRegExMatch("\\b\\w*[ti]\\w*\\b", Pattern.CASE_INSENSITIVE,
        "It is time to iterate and test this item.");

    doRegExSplit("\\|", "apple|banana|cherry|date");

    doRegExReplace("today", Pattern.CASE_INSENSITIVE, "yesterday",
        "Today I will study. I said today would be a good day, so today it is.");
}
/**
*
* @param pattern A regular-expression pattern.
* @param patternFlags Processing modification flags for the pattern.
* @param input A string to test.
*/
private static void doRegExMatch(String pattern, int patternFlags, String
input) {
List<String> matches = new ArrayList<>();
Pattern pat = Pattern.compile(pattern, patternFlags);
Matcher mat = pat.matcher(input);
int count;
for (count = 0; mat.find(); count++) {
matches.add(input.substring(mat.start(), mat.end()));
}
System.out.println(
"Matched (" + (patternFlags == Pattern.CASE_INSENSITIVE ?
"case insensitive" : "case sensitive")
+ "): \"" + pattern + "\" in \"" + input + "\" " + count + " times.");
for (int i = 0; i < count; i++) {
System.out.println("\t Match #" + (i + 1) + ": " +
matches.get(i));
}
System.out.println();
}
/**
* Fragment the input string by the given regular expression pattern.
*
* Java allows you to split strings by regular expressions. This function
will
* take a regular expression and an input string, then will produce a list of
* all fragments produced when the input string is split by the regular
* expression defined delimiter.
*
* @param pattern A regular-expression pattern.
* @param input A string to fragment.
*/
private static void doRegExSplit(String pattern, String input) {
Pattern pat = Pattern.compile(pattern);
String[] parts = pat.split(input);
System.out.print(
"Found " + parts.length + " fragments after splitting \"" +
input + "\" by \"" + pattern + "\": [");
for (int i = 0; i < parts.length; i++) {
System.out.print("\"" + parts[i] + "\"");
if (i < (parts.length - 1))
System.out.print(", ");
}
System.out.println("].");
System.out.println();
}
/**
* Replace all occurrences of the pattern, with the string literal defined in
* replace, over the input string, with patternFlag processing flags.
*
* Java allows replacement of regular expression defined regions in a string
by
* any string literal. This function will do that, and print the results.
*
* @param pattern The pattern defining the replacement regions.
* @param patternFlags Any modification flags on the pattern matching.
* @param replace A string literal used to replace the pattern regions.
* (This is not a regular expression string.)
* @param input The string upon which to perform the matching and
* replacement.
*/
private static void doRegExReplace(String pattern, int patternFlags, String
replace, String input) {
// Examples:
Pattern pat = Pattern.compile(pattern, patternFlags);
Matcher mat = pat.matcher(input);
String replaced = mat.replaceAll(replace);
System.out.println(
"Replaced all (" + (patternFlags ==
Pattern.CASE_INSENSITIVE ? "case insensitive" : "case sensitive")
+ ") occurrences of \"" + pattern + "\" in sentence \"" + input + "\" with \"" + replace
+ "\" to make: \"" + replaced + "\".");
System.out.println();
// Write your code here:
}
}
