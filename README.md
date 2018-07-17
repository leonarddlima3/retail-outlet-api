# retail-outlet-api
Tech Stack
----------

Middleware :
----------
Java
Spring MVC

Database :
--------
MySQL

Servers:
-------
Tomcat
MySQL Server


API for storing and accessing retail management data
----------------------------------------------------

API 1 : API for creating invoice for a particular customer by a billing executive (Employee) in a particular store branch

Test API Data
-------------
URL : http://localhost:8080/WebProject/rest/invoice/create?key=SHARED_KEY
Type : POST
Content-Type : application/json
Request Body : 
{
	"invoiceId" : "ID1011",
	"date" : "",
	"total" : 100,
	"tax" : 0,
	"taxPerc" : 0,
	"custId" : "C1001",
	"empId" : "E1001",
	"itemId" : ["I1001","I1002"],
	"brandId" : ["B1001","B1001"],
	"storeId" : "S1001"
}
Response Body :
{
    "status": "success",
    "code": 100
}


API 2 : API for getting inventory report of all the warehouses

Test API Data
-------------
URL : http://localhost:8080/WebProject/rest/inventory/getInventoryDetails?key=SHARED_KEY
Type : GET
Content-Type : application/json
Response Body :
{
    "status": "success",
    "code": 100,
    "data": [
        {
            "warehouseId": "W1001",
            "warehouseName": "TIMES SQUARE",
            "itemDetails": [
                {
                    "item": {
                        "itemId": "I1001",
                        "itemName": "OLIVE OIL",
                        "itemTypeId": "IT1001",
                        "itemTypeName": "OIL"
                    },
                    "brand": {
                        "brandId": "B1001",
                        "brandName": "NESTLE"
                    }
                }
            ]
        }
    ]
}



Database Schema
---------------

Test DB Data :
------------
mysql> SELECT * FROM CUSTOMER;
+---------+----------------+-------------+-----------+--------------+
| CUST_ID | CUST_NAME      | CUST_STREET | CUST_CITY | CUST_PINCODE |
+---------+----------------+-------------+-----------+--------------+
| C1001   | JOSEPH MATHIAS | GARCIA AV.  | CA        | 222223       |
+---------+----------------+-------------+-----------+--------------+
1 row in set (0.00 sec)

mysql> SELECT * FROM EMPLOYEE;
+--------+--------------+------------+----------+-------------+-------------------+---------------+------------------+
| EMP_ID | EMP_NAME     | EMP_STREET | EMP_CITY | EMP_PINCODE | EMP_DESIGNATION   | EMP_JOB_LEVEL | EMP_JOINING_DATE |
+--------+--------------+------------+----------+-------------+-------------------+---------------+------------------+
| E1001  | SCOTT ADKINS | GARCIA AV. | CA       | 222222      | BILLING EXECUTIVE | JL4           | 30-06-2014       |
+--------+--------------+------------+----------+-------------+-------------------+---------------+------------------+
1 row in set (0.00 sec)

mysql> SELECT * FROM STORE;
+----------+-------------+--------------+------------+---------------+
| STORE_ID | STORE_NAME  | STORE_STREET | STORE_CITY | STORE_PINCODE |
+----------+-------------+--------------+------------+---------------+
| S1001    | PALM SQUARE | GARCIA AV.   | CA         | 222224        |
+----------+-------------+--------------+------------+---------------+
1 row in set (0.00 sec)

mysql> SELECT * FROM BRAND;
+----------+------------+--------------+------------+---------------+
| BRAND_ID | BRAND_NAME | BRAND_STREET | BRAND_CITY | BRAND_PINCODE |
+----------+------------+--------------+------------+---------------+
| B1001    | NESTLE     | GARCIA AV.   | CA         | 222225        |
+----------+------------+--------------+------------+---------------+
1 row in set (0.00 sec)

mysql> SELECT * FROM ITEM;
+---------+--------------+--------------+-----------+------------+
| ITEM_ID | ITEM_NAME    | ITEM_TYPE_ID | ITEM_TYPE | ITEM_PRICE |
+---------+--------------+--------------+-----------+------------+
| I1001   | OLIVE OIL    | IT1001       | OIL       |        100 |
| I1002   | RICEBRAN OIL | IT1001       | OIL       |        100 |
+---------+--------------+--------------+-----------+------------+
2 rows in set (0.00 sec)

mysql> SELECT * FROM WAREHOUSE;
+--------------+----------------+------------------+----------------+-------------------+
| WAREHOUSE_ID | WAREHOUSE_NAME | WAREHOUSE_STREET | WAREHOUSE_CITY | WAREHOUSE_PINCODE |
+--------------+----------------+------------------+----------------+-------------------+
| W1001        | TIMES SQUARE   | GARCIA AV.       | CA             | 222226            |
+--------------+----------------+------------------+----------------+-------------------+
1 row in set (0.00 sec)

mysql> SELECT * FROM WAREHOUSE_STOCK;
+--------------+---------+----------+-------------+
| WAREHOUSE_ID | ITEM_ID | BRAND_ID | SUPPLIER_ID |
+--------------+---------+----------+-------------+
| W1001        | I1001   | B1001    | SU1001      |
+--------------+---------+----------+-------------+
1 row in set (0.00 sec)

mysql> SELECT * FROM SUPPLIER;
+-------------+-----------------+-----------------+---------------+------------------+
| SUPPLIER_ID | SUPPLIER_NAME   | SUPPLIER_STREET | SUPPLIER_CITY | SUPPLIER_PINCODE |
+-------------+-----------------+-----------------+---------------+------------------+
| SU1001      | GODREG SUPPLIES | GARCIA AV.      | CA            | 222227           |
+-------------+-----------------+-----------------+---------------+------------------+
1 row in set (0.01 sec)

mysql> SELECT * FROM INVOICE;
+------------+---------+--------+----------+---------+----------+
| INVOICE_ID | CUST_ID | EMP_ID | STORE_ID | ITEM_ID | BRAND_ID |
+------------+---------+--------+----------+---------+----------+
| ID1001     | C1001   | E1001  | S1001    | I1001   | B1001    |
| ID1010     | C1001   | E1001  | S1001    | I1001   | B1001    |
| ID1011     | C1001   | E1001  | S1001    | I1001   | B1001    |
| ID1011     | C1001   | E1001  | S1001    | I1002   | B1001    |
+------------+---------+--------+----------+---------+----------+
4 rows in set (0.00 sec)

mysql> SELECT * FROM INVOICE_DETAILS;
+------------+--------------+---------------+-------------+------------------+
| INVOICE_ID | INVOICE_DATE | INVOICE_TOTAL | INVOICE_TAX | INVOICE_TAX_PERC |
+------------+--------------+---------------+-------------+------------------+
| ID1001     | 30-06-2014   |           100 |           0 |                0 |
| ID1002     | 30-06-2014   |           100 |           0 |                0 |
| ID1003     | 30-06-2014   |           100 |           0 |                0 |
| ID1004     |              |           100 |           0 |                0 |
| ID1005     |              |           100 |           0 |                0 |
| ID1006     |              |           100 |           0 |                0 |
| ID1007     |              |           100 |           0 |                0 |
| ID1008     |              |           100 |           0 |                0 |
| ID1009     |              |           100 |           0 |                0 |
| ID1010     |              |           100 |           0 |                0 |
| ID1011     |              |           100 |           0 |                0 |
+------------+--------------+---------------+-------------+------------------+
11 rows in set (0.00 sec)

mysql> SELECT * FROM STORE_STOCK;
+----------+---------+----------+-------------+
| STORE_ID | ITEM_ID | BRAND_ID | SUPPLIER_ID |
+----------+---------+----------+-------------+
| S1001    | I1001   | B1001    | SU1001      |
+----------+---------+----------+-------------+
1 row in set (0.00 sec)


Relational Schema :
-----------------
mysql> SELECT                                                                                                                                                                                                   ->   `TABLE_SCHEMA`,                          -- Foreign key schema
    ->   `TABLE_NAME`,                            -- Foreign key table
    ->   `COLUMN_NAME`,                           -- Foreign key column
    ->   `REFERENCED_TABLE_SCHEMA`,               -- Origin key schema
    ->   `REFERENCED_TABLE_NAME`,                 -- Origin key table
    ->   `REFERENCED_COLUMN_NAME`                 -- Origin key column
    -> FROM
    ->   `INFORMATION_SCHEMA`.`KEY_COLUMN_USAGE`  -- Will fail if user don't have privilege
    -> WHERE
    ->   `TABLE_SCHEMA` = SCHEMA()                -- Detect current schema in USE 
    ->   AND `REFERENCED_TABLE_NAME` IS NOT NULL; -- Only tables with foreign keys
+--------------+-----------------+--------------+-------------------------+-----------------------+------------------------+
| TABLE_SCHEMA | TABLE_NAME      | COLUMN_NAME  | REFERENCED_TABLE_SCHEMA | REFERENCED_TABLE_NAME | REFERENCED_COLUMN_NAME |
+--------------+-----------------+--------------+-------------------------+-----------------------+------------------------+
| mysql        | STORE_STOCK     | BRAND_ID     | mysql                   | BRAND                 | brand_id               |
| mysql        | INVOICE         | BRAND_ID     | mysql                   | BRAND                 | brand_id               |
| mysql        | WAREHOUSE_STOCK | BRAND_ID     | mysql                   | BRAND                 | brand_id               |
| mysql        | INVOICE         | CUST_ID      | mysql                   | CUSTOMER              | cust_id                |
| mysql        | INVOICE         | EMP_ID       | mysql                   | EMPLOYEE              | emp_id                 |
| mysql        | INVOICE         | INVOICE_ID   | mysql                   | INVOICE_DETAILS       | invoice_id             |
| mysql        | STORE_STOCK     | ITEM_ID      | mysql                   | ITEM                  | item_id                |
| mysql        | INVOICE         | ITEM_ID      | mysql                   | ITEM                  | item_id                |
| mysql        | WAREHOUSE_STOCK | ITEM_ID      | mysql                   | ITEM                  | item_id                |
| mysql        | STORE_STOCK     | STORE_ID     | mysql                   | STORE                 | store_id               |
| mysql        | INVOICE         | STORE_ID     | mysql                   | STORE                 | store_id               |
| mysql        | STORE_STOCK     | SUPPLIER_ID  | mysql                   | SUPPLIER              | supplier_id            |
| mysql        | WAREHOUSE_STOCK | SUPPLIER_ID  | mysql                   | SUPPLIER              | supplier_id            |
| mysql        | WAREHOUSE_STOCK | WAREHOUSE_ID | mysql                   | WAREHOUSE             | warehouse_id           |
+--------------+-----------------+--------------+-------------------------+-----------------------+------------------------+
14 rows in set, 2 warnings (0.01 sec)


