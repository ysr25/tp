---
layout: page
title: User Guide
---

Bagel is a **desktop app for managing flashcards, optimized for use via a Command Line Interface** (CLI) while still having the benefits of a Graphical User Interface (GUI). If you can type fast, Bagel manage your flashcards faster than traditional GUI apps.

### Table of Contents
* Quick start
* Features
    - Adding a flashcard: add
    - Deleting a flashcard delete
    - Editing a flashcard: edit 
    - Viewing a flashcard: view 
    - Viewing list of all flashcards: list
    - Flipping through flashcards: flip
    - Exiting the program: exit
* Command Summary

--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Ensure you have Java 11 or above installed in your Computer.
2. Download the latest flashcard.jar from __.
3. Copy the file to the folder you want to use as the home folder for your AddressBook.
4. Double-click the file to start the app. The GUI should appear in a few seconds. Note how the app contains some sample data.
5. Type the command in the command box and press Enter to execute it. e.g. typing help and pressing Enter will open the help window.
    Some example commands you can try:
        a. list : Lists all flashcards.
        b. add t/Data Analysis d/Definition of data analysis: xxxxxx  : Adds a flashcard with the title 
        'Data Analysis' and description of 'Definition of data analysis: xxxxxx' to the list of flashcards 
        c. delete 3 : Deletes the 3rd flashcard shown in the current flashcards set.
        d. view 3 : Shows the 3rd flashcard shown in the current flashcards set.
        e. edit 2 t/New description : Edits the title of 2nd existing flashcard of the current set to become 'New description'
        f. flip : Flips from current flashcard to next flashcard in the list.
        g. exit : Exits the app.
Refer to the Features below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in add TITLE, TITLE is the parameter which can be used as add 

* User should supply the number of the flashcard behind commands to eg. add 1, delete 10
</div>

### Adding a flashcard: `add`

Adds a flashcard to the total list of flashcards.
* Adds a flashcard with a title and description
* Title and description must be entered

Format: `add t/TITLE d/DESCRIPTION`

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
A person can have any number of tags (including 0)
</div>

Examples:
* `add t/Data Analysis d/Definition of data analysis: xxxxxx`
* `add t/p-value d/If p value < 0.05, xxxx; Else, xxxx`

### Deleting a flashcard : `delete`

Deletes the specified flashcard from the total list of flashcards.

Format: `delete INDEX`

* Deletes the person at the specified `INDEX`.
* The index refers to the index number shown in the displayed flashcards list.
* The index **must be a positive integer** 1, 2, 3, …​

Examples:
* `list` followed by delete 2 deletes the 2nd flashcard in the shown list of flashcards

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
