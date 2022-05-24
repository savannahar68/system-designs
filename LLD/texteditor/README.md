Your task is to implement a simplified version of text editor.

All operations that should be supported are listed below. Partial credit will be given for each implemented operation. Please submit often to ensure partial credits are captured.

Implementation tips

Implement operations and provided steps one by one, and not all together, keeping in mind that you will need to make refactors to support each additional step. In the first three levels you can assume that only one text document is modified.

Note

After every operation, add the current state of the text to the resulting array. The returning array should consist of all the states after each operation is applied and have the same length as the # of input queries.

Level 1
The editor starts with a blank text document, with the cursor at initial position 0.

1. APPEND <text> should append the inputted string text to the document starting from the current position of the cursor. After the operation, the cursor should be at the end of the added string.

queries = [
    ["APPEND", "Hey"],                | "" -> "Hey"
    ["APPEND", " there"],             | "Hey" -> "Hey there"
    ["APPEND", "!"]                   | "Hey there" -> "Hey there!"
]

// returns: [ "Hey",
//            "Hey there",
//            "Hey there!" ]
2. MOVE <position> should move the cursor to the specified position. The cursor should be positioned between document characters, and are enumerated sequentially starting from 0. If the specified position is out of bounds, then move the cursor to the nearest available position.

queries = [
    ["APPEND", "Hey you"],            | "" -> "Hey you"
    ["MOVE", "3"],                    | moves the cursor after the first "y"
    ["APPEND", ","]                   | "Hey you" -> "Hey, you"
]

// returns: [ "Hey you",
//            "Hey you",
//            "Hey, you" ]
3. BACKSPACE should remove the character right before the cursor, if any.

queries = [
    [APPEND", "Hey you"],             | "" -> "Hey you"
    ["BACKSPACE"],                    | "Hey you" -> "Hey yo"
    ["BACKSPACE"]                     | "Hey yo" -> "Hey y"
]

// returns: [ "Hey you",
//            "Hey yo",
//            "Hey y" ]
and

queries = [
    ["APPEND", "!"],                  | "" -> "!"
    ["BACKSPACE"],                    | "!" -> ""
    ["BACKSPACE"]                     | "" -> ""
]

// returns: [ "!",
//            "",
//            "" ]
Level 2
Introduce methods to copy a part of the document text.

4. SELECT <left> <right> should select the text between the left and right cursor positions. Selection borders should be returned to the bounds of the document. If the selection is empty, it becomes a cursor position. Any modification operation replace the selected text and places the cursor at the end of the modified segment.

Additionally,

SELECT and APPEND should replace the selected characters with the appended characters
SELECT and BACKSPACE should delete the selected characters
SELECT and MOVE deselects characters if there were any and moves the cursor
For example, the following operations

queries = [
    ["APPEND", "Hello cruel world!"], | "" -> "Hello cruel world!"
    ["SELECT", "5", "11"],            | selects " cruel"
    ["APPEND", ","],                  | "Hello cruel world!" -> "Hello, world!",
                                      | as the selected part has been replaced with "," by APPEND
    ["SELECT", "5", "12"],            | selects ", world"
    ["BACKSPACE"],                    | "Hello, world!" -> "Hello!",
                                      | as the selected part has been removed by BACKSPACE
    ["SELECT", "4", "6"],             | selects "o!"
    ["MOVE", "1"]                     | moves cursor before "e", deselects "o!"
]

// returns: [ "Hello cruel world!",
//            "Hello cruel world!",
//            "Hello, world!",
//            "Hello, world!",
//            "Hello!",
//            "Hello!",
//            "Hello!" ]
produce "Hello!" with the cursor positioned after letter H.

5. COPY should copy the selected text to the clipboard, if there is an active non-empty selection. The current selected text (if any) remains selected after the operation.
6. PASTE should append the text from the clipboard. The current selected text (if any) is overwriten with the clipboard value after the operation, and the cursor is placed at the end of the pasted text.

For example, the following operations

queries = [
    ["APPEND", "Hello, world!"],      | "" -> "Hello, world!"
    ["SELECT", "5", "12"],            | selects ", world"
    ["COPY"],                         | copies ", world"
    ["MOVE", "12"],                   | moves the cursor to after "d"
    ["PASTE"],                        | "Hello, world!" -> "Hello, world, world!",
                                      | as ", world" has been pasted from the clipboard
    ["PASTE"],                        | "Hello, world, world!" -> "Hello, world, world, world!",
                                      | as ", world" has been pasted from the clipboard
    ["SELECT", "5", "19"],            | selects ", world, world"
    ["PASTE"]                         | "Hello, world, world, world!" -> "Hello, world, world!",
                                      | as selected ", world, world" has been replaced
                                      | with ", world" from the clipboard
]

// returns: [ "Hello, world!",
//            "Hello, world!",
//            "Hello, world!",
//            "Hello, world!",
//            "Hello, world, world!",
//            "Hello, world, world, world!"
//            "Hello, world, world, world!" 
//            "Hello, world, world!" ]
Level 3
The text editor should allow document changes to be tracked and reverted. Consider only operations that actually modify the contents of the text document, which are (APPEND, BACKSPACE, PASTE, UNDO, and REDO).

7. UNDO should restore the document to the state before the previous modification or REDO operation. The selection and cursor position should be also restored to the state they were before.

For example,

queries = [
    ["APPEND", "Hello, world!"],      | "" -> "Hello, world!"
    ["SELECT", "7", "12"],            | selects "world"
    ["BACKSPACE"],                    | "Hello, world!" -> "Hello, !",
                                      | as "world" has been removed by BACKSPACE
    ["UNDO"],                         | restores "Hello, world!" with "world" selected 
    ["APPEND", "you"]                 | "Hello, world!" -> "Hello, you!",
                                      | as "you" replaces the selected "world"
]

// returns: [ "Hello, world!",
//            "Hello, world!",
//            "Hello, !",
//            "Hello, world!",
//            "Hello, you!" ]
8. REDO can only be performed if the document has not been modified since the last UNDO operation. REDO should restore the state before the previous UNDO operation, including the selection and cursor position. Multiple UNDO and REDO operations can be performed in a row.

For example,

queries = [
    ["APPEND", "Hello, world!"],      | "" -> "Hello, world!"
    ["SELECT", "7", "12"],            | selects "world"
    ["BACKSPACE"],                    | "Hello, world!" -> "Hello, !"
    ["MOVE", "6"],                    | moves the cursor to after the comma 
    ["UNDO"],                         | restores "Hello, world!" with "world" selected 
    ["UNDO"],                         | restores initial ""
    ["REDO"],                         | restores "Hello, world!" with "world" selected
    ["REDO"]                          | restores "Hello, !" with the cursor after the comma
]

// returns: [ "Hello, world!",
//            "Hello, world!",
//            "Hello, !",
//            "Hello, !",
//            "Hello, world!",
//            "",
//            "Hello, world!",
//            "Hello, !" ]
Level 4
The text editor should support multiple text documents with a common clipboard.

9. CREATE <name> should create a blank text document name. If such a file already exists, ignore the operation and return empty string. Modification history is stored individually for each document.
10. SWITCH <name> should switch the current document to name. If there is no such file, ignore the operation and return empty string. When switching to a file, the position of the cursor and selection should return to the state in which they were left.

Note: it is guaranteed that all operations from previous levels will be executed on the active document. For backward compatibility, assume for Levels 1-3 there is a single, initially active document.

For example,

queries = [
    ["CREATE", "document1"],          | creates document1
    ["CREATE", "document2"],          | creates document2
    ["CREATE", "document1"],          | ignores the operation
    ["SWITCH", "document1"],          | switches to document1
    ["APPEND", "Hello, world!"],      | document1: "" -> "Hello, world!"
    ["SELECT", "7", "12"],            | selects "world"
    ["COPY"],                         | copies "world" to the clipboard
    ["SWITCH", "document2"],          | switches to document2
    ["PASTE"],                        | document2: "" -> "world"
    ["SWITCH", "document1"],          | switches to document1
    ["BACKSPACE"]                     | document1: "Hello, world!" -> "Hello, !"
]

// returns: [ "",
//            "",
//            "",
//            "",
//            "Hello, world!",
//            "Hello, world!",
//            "Hello, world!",
//            "",
//            "world",
//            "Hello, world!",
//            "Hello, !" ]
Example
