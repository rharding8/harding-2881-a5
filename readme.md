#Introduction

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

#The Basics
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
will pop up, with all values from the item populating the fields.

Then you may edit any of the fields to change the data. As with adding items,
any invalid data will result in an error message in the window, including
using a serial number that is already used in the list.

Finally, click "Update Item" to save changes. If you do not wish to save the changes,
click "Cancel" to exit back to the main interface.

#Search and Sort Items
**Searching For Items**

**Sorting Items**

#External Storage
**Saving Files**

**Loading Files**


