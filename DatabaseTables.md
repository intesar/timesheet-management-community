# database structure for User Information (LDAP) #

users [username pk char, password char, password\_strength char, encryption\_key char, is\_encrypted boolean, password\_expiration\_date date, first\_name char, last\_name char, middle\_name char, secondary\_email char, title char, company char, summary text, last\_login\_ip char, enabled boolean, lock\_reason char, secret\_question char, secret\_answer char, creation\_date date, last\_modified\_date date, is\_deleted boolean ](.md)

user\_login\_ip\_audit [username, login\_ip, audit\_date]

user\_login\_lock\_audit [username, lock\_status, audit\_date, lock\_reason]

user\_profile\_audit [username, first\_name, last\_name, middle\_name, title, company, summary,creation\_date, last\_modified\_date, audit\_user, audit\_date ](.md)

user\_address [id pk auto increment, userame, type, street, city, state, zipcode, country, is\_public, creation\_date, last\_modified\_date, is\_deleted ](.md)

user\_address\_audit[id, userame, type, street, city, state, zipcode, country, is\_public, creation\_date, last\_modified\_date, audit\_user, audit\_date  ]


user\_phone [id pk auto increment, username, type, phone\_number char, is\_public boolean, creation\_date, last\_modified\_date, is\_deleted ](.md)

user\_phone\_audit [id, username, type, phone\_number, is\_public, creation\_date, last\_modified\_date, audit\_user, audit\_date ]

user\_old\_password\_audit [username, password, password\_strength, creation\_date, last\_modified\_date, audit\_date ](.md)

community [name pk, description,creation\_date, last\_modified\_date ](.md)

user\_community[username pk, company pk, enabled, creation\_date, last\_modified\_date , expiration\_date, creation\_user, last\_modified\_user, is\_deleted](.md)

user\_community\_audit [username, company, enabled, creation\_date, last\_modified\_date , expiration\_date, creation\_user, last\_modified\_user, audit\_user, audit\_date ](.md)

user\_roles [username pk, role pk, creation\_date, last\_modified\_date, is\_deleted  ](.md)

user\_roles\_audit [username, role, creation\_date, last\_modified\_date, audit\_user, audit\_date  ]

role [role pk, type, description, creation\_date, last\_modified\_date, is\_deleted  ](.md)