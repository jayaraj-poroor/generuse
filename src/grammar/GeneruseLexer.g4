/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
lexer grammar GeneruseLexer;

COMMENT: (('#' ~[\r\n#]* '#') | ('#' ~[\r\n#]* '\r'? '\n'))  -> skip;

LB : '[' -> mode(DIRECTIVE_NAME_MODE);
RB : ']';
LP : '(';
RP : ')';
LC : '{';
RC : '}';
PERIOD: '.';
MEMBER_SEP : '\'s';
//WITH : 'with';
//USING: 'using';
//WHERE: 'where';
//WHOSE: 'whose';
GIVING: 'giving';
HAVING: 'having';
BEFORE: 'before';
AFTER: 'after';
BE: 'be';
AS: 'as';
COLON: ':';
SEMI : ';';
TRUE: 'true';
FALSE: 'false';
DIV: '/';
MUL : '*';
MOD: 'mod';
PLUS: '+';
MINUS: '-';
EQUALS: '=';
AND: 'and';
OR: 'or';
NOT: 'not';
GT : '>';
LT : '<';
GTE : '>=';
LTE : '<=';
NEQ  : 'not=';
IS: 'is';
WAS: 'was';
MUST: 'must';
ARTICLE: ('a' | 'an' | 'the');
PREPOSITION: ('with' | 'using' | 'where' | 'whose' | 'of' |
               'in' | 'on' | 'at' | 'upon' | 'to' | 'for' | 'from' | 'into');

INT: DIGIT+;
STRING: '"' (ESC|.)*? '"';
FLOAT: DIGIT+ '.' DIGIT+ | '.' DIGIT+;
WORD:  (LETTER | DIGIT) (LETTER | DIGIT | '-' | '?' | '!')*;

WS : [ \r\n\t]+ -> skip;
COMMA: ',';

fragment
ESC : '\\"' | '\\\\';
LETTER : [a-zA-Z];
DIGIT  : [0-9];

mode DIRECTIVE_NAME_MODE;
DIRECTIVE_NAME_WS : [ \t\r\n]+ -> skip;
USECASE: 'usecase' -> mode(DEFAULT_MODE);
STATE: 'state' -> mode(DEFAULT_MODE);
ACTION: 'action' -> mode(DEFAULT_MODE);
CONTEXT: 'context' -> mode(DEFAULT_MODE);
FORMULA: 'formula' -> mode(DEFAULT_MODE);
IMPORT: 'import' -> mode(DEFAULT_MODE);
NEEDS: 'needs' -> mode(DEFAULT_MODE); 
GROUP: 'group' -> mode(DEFAULT_MODE);
BRANCH: 'branch' -> mode(DEFAULT_MODE);
DO : 'do' -> mode(DEFAULT_MODE);
DATA: 'data' -> mode(DEFAULT_MODE);
PRECONDITION: 'pre-condition' -> mode(DEFAULT_MODE);
ACTORS: 'actors' -> mode(ACTORS_MODE);
BEFORE_DIRECTIVE: 'before' -> mode(DEFAULT_MODE);
AFTER_DIRECTIVE : 'after' -> mode(DEFAULT_MODE);

mode ACTORS_MODE;
ACTOR_SEP: [,\t]+;
        
ACTOR_WORD:  (LETTER | DIGIT) (LETTER | DIGIT | '-' | '?' | '!')*;

ACTOR_WS : [ \r\n]+ -> skip;
ACTOR_RB : ']' -> mode(DEFAULT_MODE);

