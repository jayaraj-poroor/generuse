/*
;Copyright (C) Jayaraj Poroor - All Rights Reserved.
;Unauthorized copying of this file, via any medium is strictly prohibited.
;Proprietary and Confidential.
;See LICENSE file at the root of this distribution for details.
 */
grammar CSV;

file : hdr row* ;
hdr : row ;

row : field (COMMA field)+ ((CR? LF)|EOF);

field
: TEXT
| STRING
|;

CR: '\r';
LF: '\n';
COMMA: ',';
TAB : '\t';
TEXT : ~[,\n\r"]+ ;
STRING : '"' ('""'|~'"')* '"' ;