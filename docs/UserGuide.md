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
2. Download the latest bagel.jar from [here](https://github.com/AY2021S1-CS2103T-W13-2/tp/releases).
3. Copy the file to the folder you want to use as the home folder for Bagel.
4. Double-click the file to start the app. The GUI should appear in a few seconds. Note how the app contains some sample data.
5. Type the command in the command box and press Enter to execute it. e.g. typing help and pressing Enter will open the help window.
    Some example commands you can try:
    * `list` : Lists all flashcards.
    * `add t/Data Analysis d/Definition of data analysis: xxxxxx` : Adds a flashcard with the title
        'Data Analysis' and description of 'Definition of data analysis: xxxxxx' to the list of flashcards
    * `clear` : Clears all flashcard entries.
    * `delete 3` : Deletes the 3rd flashcard shown in the current flashcards set.
    * `view 3` : Shows the 3rd flashcard shown in the current flashcards set.
    * `edit 2 t/New title` : Edits the title of 2nd existing flashcard of the current set to become 'New title'
    * `flip` : Flips from the current flashcard to next flashcard in the list.
    * `search k/Keyword`: Search flashcard that have matching title or description to keyword.
    * `sort r/title`: Sorts the flashcard list according to title.
    * `exit` : Exits the app.
Refer to the Features below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features

<div markdown="block" class="alert alert-info">
**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add t/TITLE`, TITLE is the parameter which can be used

* Items in square brackets are optional.<br>
  e.g. `t/TITLE [tag/TAG]` can be used as `t/p-value tag/Definition` or as `t/p-value`.<br>
  e.g. `[s/1]` is optional.

* Items with `…​` after them can be used multiple times including zero times.<br>
  e.g. in `[tag/TAG]…`, can be used as ` ` (i.e. 0 times), `tag/Definition, tag/Formula tag/Important` etc.

* User should supply the number of the flashcard behind commands.<br>
  e.g. `view 1`, `delete 10`

* Parameters can be in any order.<br>
  e.g. if the command specifies `t/TITLE d/DESCRIPTION`, `d/DESCRIPTION t/TITLE` is also acceptable.
</div>


### View help: `help`

Shows a message for link to available commands that you can use, with format and examples (i.e. User Guide).

![help message](images/helpMessage.png)

Format: `help`


### Adding a flashcard: `add`

Adds a flashcard to the total list of flashcards.

Format: `add t/TITLE d/DESCRIPTION [s/SET] [l/LINK] [tag/TAG]…​`

* Adds a flashcard with a title and description.
* Title and description must be entered.
* An optional set number (a positive integer between 1 and 99) can be added. By default (i.e. without `s/SET`),
all flashcards are added into set `1`.
* An optional link can be added. It should:
  * Have a protocol e.g. `https://example.com` instead of `example.com`.
  * Be absolute e.g. `file:///GER1000/example.png` instead of `file://example.png`.
  * Even if a URL is valid, it may not open, e.g. if the file does not exist.

<div markdown="block" class="alert alert-info">
**:information_source: Notes about the command format:**<br>
* Flashcards with different titles but same descriptions can still be added.
* Flashcards that are identical can be added to different sets.
</div>

Examples:
* `add t/p-value d/If p value < 0.05, xxxx; Else, xxxx` adds a new flashcard with the title `p-value`,
description `If p value < 0.05, xxxx; Else, xxxx` into default set `1`.
* `add t/Data Analysis d/Definition of data analysis: xxxxxx s/2` adds a new flashcard with the title `Data Analysis`,
description `Definition of data analysis: xxxxxx` into set `2`.
* `add t/dds Ratio(OR) and Risk Ratio(RR) d/R: odds(exp)/odds(unexp), RR: risk(exp)/risk(unexp) s/3 tag/OddsRatio`
adds a new flashcard with the title `dds Ratio(OR) and Risk Ratio(RR)`, description `R: odds(exp)/odds(unexp), RR: risk(exp)/risk(unexp)`
with the tag `OddsRatio` into set `3`.
* `add t/Types of Observational Studies d/Prospective, Retrospective, Cross-sectional
l/https://en.wikipedia.org/wiki/Observational_study tag/Types tag/ObservationalStudies s/2` adds a new flashcard with 
the title `Types of Observational Studies`, description `Prospective, Retrospective, Cross-sectional`,
link `https://en.wikipedia.org/wiki/Observational_study tag/Types` with the tags `Types` and `ObservationalStudies` into set `2`.

### Clearing all flashcard entries: `clear`

Clears all flashcard entries from Bagel.

Format: `clear`

### Deleting a flashcard : `delete`

Deletes the specified flashcard from the total list of flashcards.

Format: `delete INDEX`

* Deletes the flashcard at the specified `INDEX`.
* The index refers to the index number shown in the displayed flashcards list.
* The index **must be a positive integer** 1, 2, 3, …


### Editing a flashcard : `edit`

Edits an existing flashcard.

Format: `edit INDEX [t/TITLE] [d/DESCRIPTION] [s/SET] [l/LINK] [tag/TAG]…​`

* Edits the flashcard at the specified `INDEX`.
* The index refers to the index number shown in the displayed flashcard list.
* The index **must be a positive integer** 1, 2, 3, …
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.
* You can remove all the flashcard’s tags by typing `tag/` without specifying any tags after it.
* You can remove the flashcard's link by typing `l/`

Examples:
*  `edit 1 t/Data analysis` edits the title of the 1st flashcard to be `Data analysis`.
*  `edit 1 t/p-value d/probability of…` edits the title and the description of the 1st flashcard to be `p-value` and `probability of…` respectively.
*  `edit 1 s/2` edits the set number which this flashcard is in, to `2`.
*  `edit 1 t/p-value tag/` edits the title of the 1st flashcard to be `p-value` and clears all existing tags.


### Viewing a flashcard: `view`

Shows an existing flashcard in the current list.

Format: `view INDEX`

* The index refers to the index number shown in the displayed flashcards list.
* The index **must be a positive integer** 1, 2, 3, …


### Viewing all flashcards : `list`

Shows a list of all flashcards created, or shows a list of all flashcards in a chosen set.

Format: 
* `list` to show all flashcards created
* `list s/[SET_NUMBER]` to show all flashcards in set `SET_NUMBER`

Example:
* `list s/2` displays all flashcards in set `2`.


### Flipping through flashcards : `flip`

Flips from the current flashcard to the next flashcard in the list.

Format: `flip`


### Searching through flashcards : `search`

Searches for flashcards that have a matching title or description with `KEYWORD` from all flashcards.

Format: `search k/KEYWORD`

* Searches for flashcards that match with `KEYWORD`.

Examples:
*  `search k/testing` returns `testing1`, `testing2` and `testing23` 
![search example](images/searchExample.png)


### Sorting flashcards: `sort`

Sorts the current flashcard list. 

Format: `sort r/REQUIREMENT`

* Sorts the list by the specified requirement. 
* The requirement **must be one of the following**:
    * title
    * tag
    
Examples:
* `sort r/title` returns the list of flashcards, sorted in ascending alphabetical order.
* `sort r/tag` returns the list of flashcards, sorted according to each flashcard's first tag.


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
**Add** | `add t/TITLE d/DESCRIPTION [s/SET] [l/LINK] [tag/TAG]…`<br> e.g., `add t/Data Analysis d/The definition of Data Analysis is…`
**Clear** | `clear`
**Delete** | `delete INDEX`<br> e.g., `delete 3`
**Edit** | `edit INDEX [t/TITLE] [d/DESCRIPTION] [s/SET] [l/LINK] [tag/TAG]`<br> e.g.,`edit 1 t/Data analysis`
**View** | `view INDEX`<br> e.g., `view 1`
**List** | `list`
**Flip** | `flip`
**Search** | `search [k/KEYWORD]` <br> e.g., `search k/Data`
**Sort** | `sort r/REQUIREMENT` <br> e.g., `search r/tag`
**Help** | `help`
**Exit** | `exit`
