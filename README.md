## Introduction
Simple code file analyzer based on Chain of Responsibility Design Pattern, which has the ability of counting the sum of code lines, annotation lines and blank lines and specifying the total count of characters and words. 

## Usage
type a command with following syntax
> wc.exe [parameter] [file_name]|[pattern]

@@@ alternative parameter
#### counting
parameters for counting operation
- -l: return the total lines of the operating file
- -w: return the total words of the operating file
- -c: return the total characters of the operating file
- -c: return the total code lines, blank lines and annotation lines of the operating file

#### targeting
parameters for specifying operation 
- -x:  open a choose-file dialog
- -s： search the target file whose path matches the giving pattern in the last position of the command
