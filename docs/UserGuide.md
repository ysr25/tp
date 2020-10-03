---
layout: page
title: User Guide
---

Bagel is a **desktop app for managing flashcards, optimized for use via a Command Line Interface** (CLI)
while still having the benefits of a Graphical User Interface (GUI).
If you can type fast, Bagel can manage your flashcards faster than traditional GUI apps.

### Table of Contents
{:.no_toc}

* Table of Contents
{:toc}

--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Ensure you have Java 11 or above installed in your computer.
2. Download the latest flashcard.jar from [here](https://github.com/AY2021S1-CS2103T-W13-2/tp/releases).
3. Copy the file to the folder you want to use as the home folder for Bagel.
4. Double-click the file to start the app. The GUI should appear in a few seconds. Note how the app contains some sample data.
5. Type the command in the command box and press Enter to execute it.
    Some example commands you can try:
    * `list` : Lists all flashcards.
    * `add t/Data Analysis d/Definition of data analysis: xxxxxx`  : Adds a flashcard with the title
        'Data Analysis' and description of 'Definition of data analysis: xxxxxx' to the list of flashcards
    * `delete 3` : Deletes the 3rd flashcard shown in the current flashcards set.
    * `view 3` : Shows the 3rd flashcard shown in the current flashcards set.
    * `edit 2 t/New description` : Edits the title of 2nd existing flashcard of the current set to become 'New description'
    * `flip` : Flips from the current flashcard to next flashcard in the list.
    * `exit` : Exits the app.
Refer to the Features below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add t/TITLE`, TITLE is the parameter which can be used.

* User should supply the number of the flashcard behind commands.<br>
  e.g. `add 1`, `delete 10`.
</div>

### Adding a flashcard: `add`

Adds a flashcard to the total list of flashcards.
* Adds a flashcard with a title and description
* Title and description must be entered

Format: `add t/TITLE d/DESCRIPTION`

Examples:
* `add t/Data Analysis d/Definition of data analysis: xxxxxx`
* `add t/p-value d/If p value < 0.05, xxxx; Else, xxxx`

### Deleting a flashcard : `delete`

Deletes the specified flashcard from the total list of flashcards.

Format: `delete INDEX`

* Deletes the person at the specified `INDEX`.
* The index refers to the index number shown in the displayed flashcards list.
* The index **must be a positive integer** 1, 2, 3, …

### Editing a flashcard : `edit`

Edits an existing flashcard.

Format: `edit INDEX [t/TITLE] [d/DESCRIPTION]`

* Edits the person at the specified `INDEX`.
* The index refers to the index number shown in the displayed person list.
* The index **must be a positive integer** 1, 2, 3, ...
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.

Examples:
*  `edit 1 t/Data analysis` Edits the title of the 1st flashcard to be `Data analysis`.
*  `edit 1 t/p-value d/probability of ...` Edits the title and the description of the 1st flashcard to be `p-value` and `probability of ...` respectively.

### Viewing a flashcard: `view`

Show an existing flashcard in the current list.

Format: `view INDEX`

* The index refers to the index number shown in the displayed flashcards list.
* The index **must be a positive integer** 1, 2, 3, ...

### Viewing all flashcards : `list`

Shows a list of all flashcards.

Format: `list`

### Flipping through flashcards : `flip`

Flips from current flashcard to next flashcard in the list.

Format: `flip`

### Exiting the program : `exit`

Exits the program.

Format: `exit`

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: Placeholder Question<br>
**A**: Placeholder Answer

--------------------------------------------------------------------------------------------------------------------

## Command summary

Action | Format, Examples
--------|------------------
**Add** | `add t/TITLE d/DESCRIPTION`<br> e.g., `add t/Data Analysis d/The definition of Data Analysis is ...`
**Delete** | `delete INDEX`<br> e.g., `delete 3`
**Edit** | `edit INDEX t/TITLE d/DESCRIPTION`<br> e.g.,`edit 1 t/Data analysis`
**View** | `view INDEX`<br> e.g., `view 1`
**List** | `list`
**Flip** | `flip`
**Exit** | `exit`
