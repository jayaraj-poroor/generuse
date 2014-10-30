/*
;Copyright (C) Jayaraj Poroor - All Rights Reserved.
;Unauthorized copying of this file, via any medium is strictly prohibited.
;Proprietary and Confidential.
;See LICENSE file at the root of this distribution for details.
*/

grammar Generuse;

options {tokenVocab = GeneruseLexer;}

gss : groupSpec importSpec* (usecase | usecased | state | action | formula | data)*;

groupSpec : LB GROUP id RB;
importSpec : LB IMPORT id attributeValue* RB;

usecase : usecaseHeader preconditionSpec? actorSpec command*;

usecased : usecasedHeader actorSpec command*;

state : stateHeader instantSpec+ sentence+;

action : actionHeader objectSpec sentence+;

formula : formulaHeader sentence+;

data : dataHeader sentence+;

usecaseHeader : LB USECASE id (HAVING attributeValue+)? RB;
usecasedHeader : LB USECASE id (MINUS | formalParams) (HAVING attributeValue+)? RB;
stateHeader : LB STATE stateSpec (HAVING attributeValue+)? RB;
actionHeader : LB ACTION id actionSuffix? formalParams? (HAVING attributeValue+)? RB;
formulaHeader  : LB FORMULA id  formalParams? (HAVING attributeValue+)? RB;
dataHeader: LB DATA objRef attributeValue* RB;

stateSpec: (BEFORE|AFTER) id;

formalParams: (PREPOSITION ARTICLE? id (conj ARTICLE? id)*);

conj: (COMMA|AND)+;

auxVerb: (IS NOT?) | (WAS NOT?) | (MUST BE?);

id: WORD+;
actorId: ACTOR_WORD+;

objectSpec : LB CONTEXT contextSpec* LP AS id RP RB;
instantSpec   : LB (BEFORE_DIRECTIVE|AFTER_DIRECTIVE) pastSpec  PREPOSITION usecaseId RB;

usecaseId: id;

contextSpec: id COLON LP objRef RP;

attributeValue : id COLON STRING;

actorSpec : LB ACTORS ACTOR_SEP? actorId (ACTOR_SEP actorId)* ACTOR_SEP? ACTOR_RB;
preconditionSpec: LB PRECONDITION stmt RB;

doSpec : LB DO id multiParamSpec? RB;

command : sentence | doSpec | branchSpec;

branchSpec : LB BRANCH stmt? RB;

sentence: (stmt (SEMI stmt)* PERIOD) | PERIOD;

objRefEx: objRef stateSpec?;

expr: objRefEx | LP expr RP | literal | 
      op=NOT expr | op=MINUS expr |      
      expr op=MUL expr | expr op=DIV expr | expr op=MOD expr | 
      expr op=PLUS expr | expr op=MINUS expr | expr op=EQUALS expr |      
      expr op=LT expr | expr op=GT expr | expr op=LTE expr |
      expr op=GTE expr | expr op=NEQ expr |
      expr op=AND expr | expr op=OR expr 
      ;

literal: INT | FLOAT | STRING | TRUE | FALSE;

stmt : actionId 
       PREPOSITION? 
       ARTICLE 
       expr 
       multiParamSpec? 
       ((GIVING|BE) ARTICLE? resultId)? 
       actionSuffix? 
       noteSpec?
       | 
       ARTICLE? expr auxVerb actionId ((BEFORE|AFTER) pastSpec)?;
actionId: id;
actionSuffix: PREPOSITION ARTICLE? id;
resultId: id;
pastSpec: actionId (PREPOSITION ARTICLE? objRef timeSpec?)?;
timeSpec: ARTICLE id;

noteSpec: LP notePrefix expr noteSuffix? RP;
notePrefix: WORD;
noteSuffix: WORD;

multiParamSpec : PREPOSITION 
                 ( (ARTICLE? paramName IS expr) |
                   (expr AS ARTICLE? paramName) |
                   autoParam
                 )
                 (conj 
                    ((ARTICLE? paramName IS expr)|
                     (expr AS ARTICLE? paramName) |
                     autoParam
                    )
                 )*;
autoParam : objRefEx;

paramName: id;

objRef: id  (MEMBER_SEP objField)*;

objField: id;
