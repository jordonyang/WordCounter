## Introduction
Simple code file analyzer based on Chain of Responsibility Design Pattern, which has the ability of counting the sum of code lines, annotation lines and blank lines and specifying the total count of characters and words. 

## Usage
type a command with following syntax
> wc.exe \[parameter][file_name]\|[pattern]

### alternative parameter
#### counting
parameters for counting operation
- -l: return the total lines of the operating file
- -w: return the total words of the operating file
- -c: return the total characters of the operating file
- -a: return the total code lines, blank lines and annotation lines of the operating file

![img](http://pezmn9eoj.bkt.clouddn.com/multiargs.png)

#### targeting
parameters for specifying files operation 
- -x:  open a choose-file dialog, multiSelection supported.

  ![img](http://pezmn9eoj.bkt.clouddn.com/xargs.png)

- -s： search the target file whose path matches the giving pattern in the last position of the command

### pattern

![img](http://pezmn9eoj.bkt.clouddn.com/pattern1.png)

The last parameter is a regex when there is a `-s` in the other parameters, it can match some common pattern for locating files, just like some shell scripts but quite rougher than that.

#### /usr/local/java/*.java
Matches all files whose name ends with ".java" in /usr/local/java/ as well as its children   
#### *.java  
Matches all files whose name ends with ".java" in current working directory as well as its children   

#### ?ps.c    
? can be any word character
#### [1-100]vm.c   
Matches all files whose name's first character ranges from 1 to 100, such as `2vm.c`


## Test Case
It is such an awesome way to run test cases with `jacoco`, not only does it run all unit test in all your test files automatically, most importantly and amazingly it would also generates a site which contains some visual reports showing you the `code coverage` of your project very concretely.

![img](http://pezmn9eoj.bkt.clouddn.com/cov.png)





