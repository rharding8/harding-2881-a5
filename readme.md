Introduction
-

Inventory Manager is a simple program to 
manage an inventory of items,
intended for small business use 
or personal shops.

Every item input into the list will have
a unique 10-character serial number composed
of numbers and letters, a name,
and a monetary value (US $) 
provided by the user.
All items will display in a table, and 
can be saved to and loaded from
JSon, HTML, and txt files.

The Basics
-
**Adding Items**

To add an item into the list, click the "Add Item" button. A window asking for a serial number,
name, and price value will appear. Every serial number should be in the format
"*XXXXXXXXXX*" with alphanumeric characters,
names must be no longer than 256 characters long,
and the price must be a monetary value.

Should any data entered be invalid, an error message will display in the window.
This includes if the serial number entered is already included in the list.

After completing all fields, click the "Add Item" button. 
The item will be added to the table, and the window will close.
You may also click the "Cancel" button to exit the window at any time.

**Removing Items**

To remove an item from the list, simply click an item on the list
and click "Remove Item". The button will be greyed out until you have selected
an item.

**Editing Items**

To edit an item in the list, click the item you wish to
edit and then click "Edit Item" (Which will remain greyed out 
until you have selected an item). A window very much like the "Add Item" window
will pop up. Click somewhere in the blank space of the window to populate the fields with
the existing information.

Then you may edit any of the fields to change the data. As with adding items,
any invalid data will result in an error message in the window, including
using a serial number that is already used in the list.

Finally, click "Update Item" to save changes. If you do not wish to save the changes,
click "Cancel" to exit back to the main interface.

Search and Sort Items
-
**Searching For Items**

To search for an item, enter the name or serial number you want to search for in the
search box. Then select either "Name" or "Serial Number" from the drop-down box and click
"Search". If the item is found, it will be highlighted in the table. If there is nothing selected,
the item was not found.

**Sorting Items**

Sorting the table is easy, simply click the column heading for the column you want to
sort by. One click will set to ascending order, the next to descending order, and the third click will reset
back to the original order. The latter will also happen if you click "Refresh List" and when items are
added, removed, or changed.

External Storage
-
**Saving Files**

To save your Inventory to an external file, click the "Save Inventory" button.
A window will pop up asking you to select where you want to save the file, what to name
it, and what file format to save as. You may save your file as a tab-separated text file,
an HTML file, or a JSon file. Click save when you've chosen a spot for the file. If no error message
pops up near the Save and Load buttons, the file has been saved in that location.

**Loading Files**

To load an Inventory from an external file, click the "Load Inventory" button. A window
will pop up asking for the file. Find the file in the window and click "Open". If it loads successfully,
you will see that Inventory populate your table. If not, an error message will pop up next to the buttons.
Reminder, the only accepted files are txt files, HTML files, or JSon files, and files created by other Inventory
Managers may not load correctly.

**WARNING ON LOADING FILES**

Just as a note, successfully loading an Inventory from a file WILL clear the current Inventory in memory. If
attempting to manage multiple inventories, remember to save your current inventory before loading
another and thus wiping out your current memory.

Acknowledgements
-

Apache for creating open source methods used in this program.

Intellij for being easy to use.

Finally, to the makers of Fire Emblem Awakening for creating the game I used to wind down
from long sessions of programming.