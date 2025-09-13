# Regular Expressions (Regex)

Regular Expressions (regex) are patterns used to match sequences of characters within strings. They are widely used for searching, validation, and text processing.

---

## Applications
- **TCP/IP** → Communication tools
- **Pattern Matching & Validation Applications**
- **Digital Circuits** → e.g., binary adder (output is known, can be validated)

---

## Core Concepts

1. **Regular Expressions**
2. **Pattern**
3. **Matcher**
4. **Character Classes**
5. **Pre-defined Character Classes**
6. **Quantifiers**
7. **Pattern Class `split()`**
8. **String Class `split()`**
9. **StringTokenizer**

---

### Pattern
- Compiled version of a regular expression
- Equivalent to a Java `Pattern` object

### Matcher
- Used to match a pattern in a string
- Created using `matcher()` method in `Pattern`

**Important Methods:**
- `int find()`
- `int end()`
- `int start()`
- `String group()`

---

## Character Classes
```regex
[abc]       # Either 'a' or 'b' or 'c'
[^abc]      # Except 'a', 'b', or 'c'
[a-zA-Z]    # Any alphabet (lowercase or uppercase)
[a-zA-Z0-9] # Alphanumeric characters
```

---

## Pre-defined Classes
```regex
\s   # Space character
\S   # Any character except space
\d   # Digits
\D   # Any character except digits
\w   # Word characters [a-zA-Z0-9]
\W   # Non-word characters (special symbols)
.    # Any character (including special)
```

---

## Quantifiers
Specify number of occurrences of a character or group:
```regex
a     # One time
a*    # Zero or more times
a+    # One or more times
a?    # At most one time
```

---

## Pattern `split()`
Used to split strings based on regex patterns.
```java
Pattern pattern = Pattern.compile("\\s");
String st[] = pattern.split("Durga software solution");
```

⚠️ Important:
- `.split(".")` → Won’t work as expected (since `.` matches everything)
- `.split("\\.")` → Correct way to split on a dot
- `.split("[.]")` → Alternative to split on a dot

---

## String Class `split()`
```java
String s = "Hello world";
String s1[] = s.split("\\s"); // Splits on spaces
```

- `String.split()` → Takes regex as argument
- `Pattern.split()` → Takes target string as argument

---

## StringTokenizer
- Found in `java.util`
- Designed for tokenizing strings
- By default, splits on whitespace if no delimiter provided

---

## Common Regex Patterns

### Mobile Numbers (India)
```regex
[789][0-9]{9}
```

### With Country Code (91)
```regex
(\+91)?[789][0-9]{9}
```

### Email IDs
```regex
[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}
```

---

## Summary
Regex provides powerful tools for:
- String validation
- Searching
- Pattern matching
- Splitting and tokenizing strings

It is widely used in networking, compilers, input validation, and data processing.
