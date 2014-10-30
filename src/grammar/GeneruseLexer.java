// Generated from GeneruseLexer.g4 by ANTLR 4.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GeneruseLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COMMENT=1, LB=2, RB=3, LP=4, RP=5, LC=6, RC=7, PERIOD=8, MEMBER_SEP=9, 
		GIVING=10, HAVING=11, BEFORE=12, AFTER=13, BE=14, AS=15, COLON=16, SEMI=17, 
		TRUE=18, FALSE=19, DIV=20, MUL=21, MOD=22, PLUS=23, MINUS=24, EQUALS=25, 
		AND=26, OR=27, NOT=28, GT=29, LT=30, GTE=31, LTE=32, NEQ=33, IS=34, WAS=35, 
		MUST=36, ARTICLE=37, PREPOSITION=38, INT=39, STRING=40, FLOAT=41, WORD=42, 
		WS=43, COMMA=44, LETTER=45, DIGIT=46, DIRECTIVE_NAME_WS=47, USECASE=48, 
		STATE=49, ACTION=50, CONTEXT=51, FORMULA=52, IMPORT=53, NEEDS=54, GROUP=55, 
		BRANCH=56, DO=57, DATA=58, PRECONDITION=59, ACTORS=60, BEFORE_DIRECTIVE=61, 
		AFTER_DIRECTIVE=62, ACTOR_SEP=63, ACTOR_WORD=64, ACTOR_WS=65, ACTOR_RB=66;
	public static final int DIRECTIVE_NAME_MODE = 1;
	public static final int ACTORS_MODE = 2;
	public static String[] modeNames = {
		"DEFAULT_MODE", "DIRECTIVE_NAME_MODE", "ACTORS_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"COMMENT", "'['", "RB", "'('", "')'", "'{'", "'}'", "'.'", "''s'", "'giving'", 
		"'having'", "BEFORE", "AFTER", "'be'", "'as'", "':'", "';'", "'true'", 
		"'false'", "'/'", "'*'", "'mod'", "'+'", "'-'", "'='", "'and'", "'or'", 
		"'not'", "'>'", "'<'", "'>='", "'<='", "'not='", "'is'", "'was'", "'must'", 
		"ARTICLE", "PREPOSITION", "INT", "STRING", "FLOAT", "WORD", "WS", "','", 
		"LETTER", "DIGIT", "DIRECTIVE_NAME_WS", "'usecase'", "'state'", "'action'", 
		"'context'", "'formula'", "'import'", "'needs'", "'group'", "'branch'", 
		"'do'", "'data'", "'pre-condition'", "'actors'", "BEFORE_DIRECTIVE", "AFTER_DIRECTIVE", 
		"ACTOR_SEP", "ACTOR_WORD", "ACTOR_WS", "ACTOR_RB"
	};
	public static final String[] ruleNames = {
		"COMMENT", "LB", "RB", "LP", "RP", "LC", "RC", "PERIOD", "MEMBER_SEP", 
		"GIVING", "HAVING", "BEFORE", "AFTER", "BE", "AS", "COLON", "SEMI", "TRUE", 
		"FALSE", "DIV", "MUL", "MOD", "PLUS", "MINUS", "EQUALS", "AND", "OR", 
		"NOT", "GT", "LT", "GTE", "LTE", "NEQ", "IS", "WAS", "MUST", "ARTICLE", 
		"PREPOSITION", "INT", "STRING", "FLOAT", "WORD", "WS", "COMMA", "ESC", 
		"LETTER", "DIGIT", "DIRECTIVE_NAME_WS", "USECASE", "STATE", "ACTION", 
		"CONTEXT", "FORMULA", "IMPORT", "NEEDS", "GROUP", "BRANCH", "DO", "DATA", 
		"PRECONDITION", "ACTORS", "BEFORE_DIRECTIVE", "AFTER_DIRECTIVE", "ACTOR_SEP", 
		"ACTOR_WORD", "ACTOR_WS", "ACTOR_RB"
	};


	public GeneruseLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "GeneruseLexer.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 0: COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 1: LB_action((RuleContext)_localctx, actionIndex); break;

		case 42: WS_action((RuleContext)_localctx, actionIndex); break;

		case 47: DIRECTIVE_NAME_WS_action((RuleContext)_localctx, actionIndex); break;

		case 48: USECASE_action((RuleContext)_localctx, actionIndex); break;

		case 49: STATE_action((RuleContext)_localctx, actionIndex); break;

		case 50: ACTION_action((RuleContext)_localctx, actionIndex); break;

		case 51: CONTEXT_action((RuleContext)_localctx, actionIndex); break;

		case 52: FORMULA_action((RuleContext)_localctx, actionIndex); break;

		case 53: IMPORT_action((RuleContext)_localctx, actionIndex); break;

		case 54: NEEDS_action((RuleContext)_localctx, actionIndex); break;

		case 55: GROUP_action((RuleContext)_localctx, actionIndex); break;

		case 56: BRANCH_action((RuleContext)_localctx, actionIndex); break;

		case 57: DO_action((RuleContext)_localctx, actionIndex); break;

		case 58: DATA_action((RuleContext)_localctx, actionIndex); break;

		case 59: PRECONDITION_action((RuleContext)_localctx, actionIndex); break;

		case 60: ACTORS_action((RuleContext)_localctx, actionIndex); break;

		case 61: BEFORE_DIRECTIVE_action((RuleContext)_localctx, actionIndex); break;

		case 62: AFTER_DIRECTIVE_action((RuleContext)_localctx, actionIndex); break;

		case 65: ACTOR_WS_action((RuleContext)_localctx, actionIndex); break;

		case 66: ACTOR_RB_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void BEFORE_DIRECTIVE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 17: _mode = DEFAULT_MODE;  break;
		}
	}
	private void STATE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 5: _mode = DEFAULT_MODE;  break;
		}
	}
	private void GROUP_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 11: _mode = DEFAULT_MODE;  break;
		}
	}
	private void IMPORT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 9: _mode = DEFAULT_MODE;  break;
		}
	}
	private void NEEDS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 10: _mode = DEFAULT_MODE;  break;
		}
	}
	private void ACTOR_RB_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 20: _mode = DEFAULT_MODE;  break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2: skip();  break;
		}
	}
	private void AFTER_DIRECTIVE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 18: _mode = DEFAULT_MODE;  break;
		}
	}
	private void USECASE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 4: _mode = DEFAULT_MODE;  break;
		}
	}
	private void FORMULA_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 8: _mode = DEFAULT_MODE;  break;
		}
	}
	private void PRECONDITION_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 15: _mode = DEFAULT_MODE;  break;
		}
	}
	private void ACTOR_WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 19: skip();  break;
		}
	}
	private void BRANCH_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 12: _mode = DEFAULT_MODE;  break;
		}
	}
	private void DIRECTIVE_NAME_WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3: skip();  break;
		}
	}
	private void DO_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 13: _mode = DEFAULT_MODE;  break;
		}
	}
	private void LB_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1: _mode = DIRECTIVE_NAME_MODE;  break;
		}
	}
	private void COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}
	private void DATA_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 14: _mode = DEFAULT_MODE;  break;
		}
	}
	private void ACTION_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 6: _mode = DEFAULT_MODE;  break;
		}
	}
	private void CONTEXT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 7: _mode = DEFAULT_MODE;  break;
		}
	}
	private void ACTORS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 16: _mode = ACTORS_MODE;  break;
		}
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2D\u023a\b\1\b\1\b"+
		"\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n"+
		"\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21"+
		"\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30"+
		"\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37"+
		"\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t"+
		"*\4+\t+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63"+
		"\4\64\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t"+
		"<\4=\t=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\3\2\3\2\7\2\u008e\n"+
		"\2\f\2\16\2\u0091\13\2\3\2\3\2\3\2\7\2\u0096\n\2\f\2\16\2\u0099\13\2\3"+
		"\2\5\2\u009c\n\2\3\2\5\2\u009f\n\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\5"+
		"\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21"+
		"\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\25"+
		"\3\25\3\26\3\26\3\27\3\27\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33"+
		"\3\33\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\36\3\36\3\37\3\37"+
		"\3 \3 \3 \3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3$\3$\3$\3$\3%\3%\3%\3"+
		"%\3%\3&\3&\3&\3&\3&\3&\5&\u0120\n&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'"+
		"\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3"+
		"\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'"+
		"\5\'\u014e\n\'\3(\6(\u0151\n(\r(\16(\u0152\3)\3)\3)\7)\u0158\n)\f)\16"+
		")\u015b\13)\3)\3)\3*\6*\u0160\n*\r*\16*\u0161\3*\3*\6*\u0166\n*\r*\16"+
		"*\u0167\3*\3*\6*\u016c\n*\r*\16*\u016d\5*\u0170\n*\3+\3+\5+\u0174\n+\3"+
		"+\3+\3+\7+\u0179\n+\f+\16+\u017c\13+\3,\6,\u017f\n,\r,\16,\u0180\3,\3"+
		",\3-\3-\3.\3.\3.\3.\5.\u018b\n.\3/\3/\3\60\3\60\3\61\6\61\u0192\n\61\r"+
		"\61\16\61\u0193\3\61\3\61\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62"+
		"\3\62\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\64\3\64\3\64\3\64\3\64"+
		"\3\64\3\64\3\64\3\64\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65"+
		"\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\67\3\67\3\67\3\67"+
		"\3\67\3\67\3\67\3\67\3\67\38\38\38\38\38\38\38\38\39\39\39\39\39\39\3"+
		"9\39\3:\3:\3:\3:\3:\3:\3:\3:\3:\3;\3;\3;\3;\3;\3<\3<\3<\3<\3<\3<\3<\3"+
		"=\3=\3=\3=\3=\3=\3=\3=\3=\3=\3=\3=\3=\3=\3=\3=\3>\3>\3>\3>\3>\3>\3>\3"+
		">\3>\3?\3?\3?\3?\3?\3?\3?\3?\3?\3@\3@\3@\3@\3@\3@\3@\3@\3A\6A\u0220\n"+
		"A\rA\16A\u0221\3B\3B\5B\u0226\nB\3B\3B\3B\7B\u022b\nB\fB\16B\u022e\13"+
		"B\3C\6C\u0231\nC\rC\16C\u0232\3C\3C\3D\3D\3D\3D\3\u0159E\5\3\2\7\4\3\t"+
		"\5\1\13\6\1\r\7\1\17\b\1\21\t\1\23\n\1\25\13\1\27\f\1\31\r\1\33\16\1\35"+
		"\17\1\37\20\1!\21\1#\22\1%\23\1\'\24\1)\25\1+\26\1-\27\1/\30\1\61\31\1"+
		"\63\32\1\65\33\1\67\34\19\35\1;\36\1=\37\1? \1A!\1C\"\1E#\1G$\1I%\1K&"+
		"\1M\'\1O(\1Q)\1S*\1U+\1W,\1Y-\4[.\1]\2\1_/\1a\60\1c\61\5e\62\6g\63\7i"+
		"\64\bk\65\tm\66\no\67\13q8\fs9\ru:\16w;\17y<\20{=\21}>\22\177?\23\u0081"+
		"@\24\u0083A\1\u0085B\1\u0087C\25\u0089D\26\5\2\3\4\t\5\2\f\f\17\17%%\5"+
		"\2##//AA\5\2\13\f\17\17\"\"\4\2C\\c|\3\2\62;\4\2\13\13..\5\2\f\f\17\17"+
		"\"\"\u025c\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2"+
		"\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2"+
		"\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2"+
		"\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2"+
		"\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2"+
		"\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2"+
		"\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U"+
		"\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\3c\3\2"+
		"\2\2\3e\3\2\2\2\3g\3\2\2\2\3i\3\2\2\2\3k\3\2\2\2\3m\3\2\2\2\3o\3\2\2\2"+
		"\3q\3\2\2\2\3s\3\2\2\2\3u\3\2\2\2\3w\3\2\2\2\3y\3\2\2\2\3{\3\2\2\2\3}"+
		"\3\2\2\2\3\177\3\2\2\2\3\u0081\3\2\2\2\4\u0083\3\2\2\2\4\u0085\3\2\2\2"+
		"\4\u0087\3\2\2\2\4\u0089\3\2\2\2\5\u009e\3\2\2\2\7\u00a2\3\2\2\2\t\u00a6"+
		"\3\2\2\2\13\u00a8\3\2\2\2\r\u00aa\3\2\2\2\17\u00ac\3\2\2\2\21\u00ae\3"+
		"\2\2\2\23\u00b0\3\2\2\2\25\u00b2\3\2\2\2\27\u00b5\3\2\2\2\31\u00bc\3\2"+
		"\2\2\33\u00c3\3\2\2\2\35\u00ca\3\2\2\2\37\u00d0\3\2\2\2!\u00d3\3\2\2\2"+
		"#\u00d6\3\2\2\2%\u00d8\3\2\2\2\'\u00da\3\2\2\2)\u00df\3\2\2\2+\u00e5\3"+
		"\2\2\2-\u00e7\3\2\2\2/\u00e9\3\2\2\2\61\u00ed\3\2\2\2\63\u00ef\3\2\2\2"+
		"\65\u00f1\3\2\2\2\67\u00f3\3\2\2\29\u00f7\3\2\2\2;\u00fa\3\2\2\2=\u00fe"+
		"\3\2\2\2?\u0100\3\2\2\2A\u0102\3\2\2\2C\u0105\3\2\2\2E\u0108\3\2\2\2G"+
		"\u010d\3\2\2\2I\u0110\3\2\2\2K\u0114\3\2\2\2M\u011f\3\2\2\2O\u014d\3\2"+
		"\2\2Q\u0150\3\2\2\2S\u0154\3\2\2\2U\u016f\3\2\2\2W\u0173\3\2\2\2Y\u017e"+
		"\3\2\2\2[\u0184\3\2\2\2]\u018a\3\2\2\2_\u018c\3\2\2\2a\u018e\3\2\2\2c"+
		"\u0191\3\2\2\2e\u0197\3\2\2\2g\u01a1\3\2\2\2i\u01a9\3\2\2\2k\u01b2\3\2"+
		"\2\2m\u01bc\3\2\2\2o\u01c6\3\2\2\2q\u01cf\3\2\2\2s\u01d7\3\2\2\2u\u01df"+
		"\3\2\2\2w\u01e8\3\2\2\2y\u01ed\3\2\2\2{\u01f4\3\2\2\2}\u0204\3\2\2\2\177"+
		"\u020d\3\2\2\2\u0081\u0216\3\2\2\2\u0083\u021f\3\2\2\2\u0085\u0225\3\2"+
		"\2\2\u0087\u0230\3\2\2\2\u0089\u0236\3\2\2\2\u008b\u008f\7%\2\2\u008c"+
		"\u008e\n\2\2\2\u008d\u008c\3\2\2\2\u008e\u0091\3\2\2\2\u008f\u008d\3\2"+
		"\2\2\u008f\u0090\3\2\2\2\u0090\u0092\3\2\2\2\u0091\u008f\3\2\2\2\u0092"+
		"\u009f\7%\2\2\u0093\u0097\7%\2\2\u0094\u0096\n\2\2\2\u0095\u0094\3\2\2"+
		"\2\u0096\u0099\3\2\2\2\u0097\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u009b"+
		"\3\2\2\2\u0099\u0097\3\2\2\2\u009a\u009c\7\17\2\2\u009b\u009a\3\2\2\2"+
		"\u009b\u009c\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009f\7\f\2\2\u009e\u008b"+
		"\3\2\2\2\u009e\u0093\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a1\b\2\2\2\u00a1"+
		"\6\3\2\2\2\u00a2\u00a3\7]\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a5\b\3\3\2"+
		"\u00a5\b\3\2\2\2\u00a6\u00a7\7_\2\2\u00a7\n\3\2\2\2\u00a8\u00a9\7*\2\2"+
		"\u00a9\f\3\2\2\2\u00aa\u00ab\7+\2\2\u00ab\16\3\2\2\2\u00ac\u00ad\7}\2"+
		"\2\u00ad\20\3\2\2\2\u00ae\u00af\7\177\2\2\u00af\22\3\2\2\2\u00b0\u00b1"+
		"\7\60\2\2\u00b1\24\3\2\2\2\u00b2\u00b3\7)\2\2\u00b3\u00b4\7u\2\2\u00b4"+
		"\26\3\2\2\2\u00b5\u00b6\7i\2\2\u00b6\u00b7\7k\2\2\u00b7\u00b8\7x\2\2\u00b8"+
		"\u00b9\7k\2\2\u00b9\u00ba\7p\2\2\u00ba\u00bb\7i\2\2\u00bb\30\3\2\2\2\u00bc"+
		"\u00bd\7j\2\2\u00bd\u00be\7c\2\2\u00be\u00bf\7x\2\2\u00bf\u00c0\7k\2\2"+
		"\u00c0\u00c1\7p\2\2\u00c1\u00c2\7i\2\2\u00c2\32\3\2\2\2\u00c3\u00c4\7"+
		"d\2\2\u00c4\u00c5\7g\2\2\u00c5\u00c6\7h\2\2\u00c6\u00c7\7q\2\2\u00c7\u00c8"+
		"\7t\2\2\u00c8\u00c9\7g\2\2\u00c9\34\3\2\2\2\u00ca\u00cb\7c\2\2\u00cb\u00cc"+
		"\7h\2\2\u00cc\u00cd\7v\2\2\u00cd\u00ce\7g\2\2\u00ce\u00cf\7t\2\2\u00cf"+
		"\36\3\2\2\2\u00d0\u00d1\7d\2\2\u00d1\u00d2\7g\2\2\u00d2 \3\2\2\2\u00d3"+
		"\u00d4\7c\2\2\u00d4\u00d5\7u\2\2\u00d5\"\3\2\2\2\u00d6\u00d7\7<\2\2\u00d7"+
		"$\3\2\2\2\u00d8\u00d9\7=\2\2\u00d9&\3\2\2\2\u00da\u00db\7v\2\2\u00db\u00dc"+
		"\7t\2\2\u00dc\u00dd\7w\2\2\u00dd\u00de\7g\2\2\u00de(\3\2\2\2\u00df\u00e0"+
		"\7h\2\2\u00e0\u00e1\7c\2\2\u00e1\u00e2\7n\2\2\u00e2\u00e3\7u\2\2\u00e3"+
		"\u00e4\7g\2\2\u00e4*\3\2\2\2\u00e5\u00e6\7\61\2\2\u00e6,\3\2\2\2\u00e7"+
		"\u00e8\7,\2\2\u00e8.\3\2\2\2\u00e9\u00ea\7o\2\2\u00ea\u00eb\7q\2\2\u00eb"+
		"\u00ec\7f\2\2\u00ec\60\3\2\2\2\u00ed\u00ee\7-\2\2\u00ee\62\3\2\2\2\u00ef"+
		"\u00f0\7/\2\2\u00f0\64\3\2\2\2\u00f1\u00f2\7?\2\2\u00f2\66\3\2\2\2\u00f3"+
		"\u00f4\7c\2\2\u00f4\u00f5\7p\2\2\u00f5\u00f6\7f\2\2\u00f68\3\2\2\2\u00f7"+
		"\u00f8\7q\2\2\u00f8\u00f9\7t\2\2\u00f9:\3\2\2\2\u00fa\u00fb\7p\2\2\u00fb"+
		"\u00fc\7q\2\2\u00fc\u00fd\7v\2\2\u00fd<\3\2\2\2\u00fe\u00ff\7@\2\2\u00ff"+
		">\3\2\2\2\u0100\u0101\7>\2\2\u0101@\3\2\2\2\u0102\u0103\7@\2\2\u0103\u0104"+
		"\7?\2\2\u0104B\3\2\2\2\u0105\u0106\7>\2\2\u0106\u0107\7?\2\2\u0107D\3"+
		"\2\2\2\u0108\u0109\7p\2\2\u0109\u010a\7q\2\2\u010a\u010b\7v\2\2\u010b"+
		"\u010c\7?\2\2\u010cF\3\2\2\2\u010d\u010e\7k\2\2\u010e\u010f\7u\2\2\u010f"+
		"H\3\2\2\2\u0110\u0111\7y\2\2\u0111\u0112\7c\2\2\u0112\u0113\7u\2\2\u0113"+
		"J\3\2\2\2\u0114\u0115\7o\2\2\u0115\u0116\7w\2\2\u0116\u0117\7u\2\2\u0117"+
		"\u0118\7v\2\2\u0118L\3\2\2\2\u0119\u0120\7c\2\2\u011a\u011b\7c\2\2\u011b"+
		"\u0120\7p\2\2\u011c\u011d\7v\2\2\u011d\u011e\7j\2\2\u011e\u0120\7g\2\2"+
		"\u011f\u0119\3\2\2\2\u011f\u011a\3\2\2\2\u011f\u011c\3\2\2\2\u0120N\3"+
		"\2\2\2\u0121\u0122\7y\2\2\u0122\u0123\7k\2\2\u0123\u0124\7v\2\2\u0124"+
		"\u014e\7j\2\2\u0125\u0126\7w\2\2\u0126\u0127\7u\2\2\u0127\u0128\7k\2\2"+
		"\u0128\u0129\7p\2\2\u0129\u014e\7i\2\2\u012a\u012b\7y\2\2\u012b\u012c"+
		"\7j\2\2\u012c\u012d\7g\2\2\u012d\u012e\7t\2\2\u012e\u014e\7g\2\2\u012f"+
		"\u0130\7y\2\2\u0130\u0131\7j\2\2\u0131\u0132\7q\2\2\u0132\u0133\7u\2\2"+
		"\u0133\u014e\7g\2\2\u0134\u0135\7q\2\2\u0135\u014e\7h\2\2\u0136\u0137"+
		"\7k\2\2\u0137\u014e\7p\2\2\u0138\u0139\7q\2\2\u0139\u014e\7p\2\2\u013a"+
		"\u013b\7c\2\2\u013b\u014e\7v\2\2\u013c\u013d\7w\2\2\u013d\u013e\7r\2\2"+
		"\u013e\u013f\7q\2\2\u013f\u014e\7p\2\2\u0140\u0141\7v\2\2\u0141\u014e"+
		"\7q\2\2\u0142\u0143\7h\2\2\u0143\u0144\7q\2\2\u0144\u014e\7t\2\2\u0145"+
		"\u0146\7h\2\2\u0146\u0147\7t\2\2\u0147\u0148\7q\2\2\u0148\u014e\7o\2\2"+
		"\u0149\u014a\7k\2\2\u014a\u014b\7p\2\2\u014b\u014c\7v\2\2\u014c\u014e"+
		"\7q\2\2\u014d\u0121\3\2\2\2\u014d\u0125\3\2\2\2\u014d\u012a\3\2\2\2\u014d"+
		"\u012f\3\2\2\2\u014d\u0134\3\2\2\2\u014d\u0136\3\2\2\2\u014d\u0138\3\2"+
		"\2\2\u014d\u013a\3\2\2\2\u014d\u013c\3\2\2\2\u014d\u0140\3\2\2\2\u014d"+
		"\u0142\3\2\2\2\u014d\u0145\3\2\2\2\u014d\u0149\3\2\2\2\u014eP\3\2\2\2"+
		"\u014f\u0151\5a\60\2\u0150\u014f\3\2\2\2\u0151\u0152\3\2\2\2\u0152\u0150"+
		"\3\2\2\2\u0152\u0153\3\2\2\2\u0153R\3\2\2\2\u0154\u0159\7$\2\2\u0155\u0158"+
		"\5].\2\u0156\u0158\13\2\2\2\u0157\u0155\3\2\2\2\u0157\u0156\3\2\2\2\u0158"+
		"\u015b\3\2\2\2\u0159\u015a\3\2\2\2\u0159\u0157\3\2\2\2\u015a\u015c\3\2"+
		"\2\2\u015b\u0159\3\2\2\2\u015c\u015d\7$\2\2\u015dT\3\2\2\2\u015e\u0160"+
		"\5a\60\2\u015f\u015e\3\2\2\2\u0160\u0161\3\2\2\2\u0161\u015f\3\2\2\2\u0161"+
		"\u0162\3\2\2\2\u0162\u0163\3\2\2\2\u0163\u0165\7\60\2\2\u0164\u0166\5"+
		"a\60\2\u0165\u0164\3\2\2\2\u0166\u0167\3\2\2\2\u0167\u0165\3\2\2\2\u0167"+
		"\u0168\3\2\2\2\u0168\u0170\3\2\2\2\u0169\u016b\7\60\2\2\u016a\u016c\5"+
		"a\60\2\u016b\u016a\3\2\2\2\u016c\u016d\3\2\2\2\u016d\u016b\3\2\2\2\u016d"+
		"\u016e\3\2\2\2\u016e\u0170\3\2\2\2\u016f\u015f\3\2\2\2\u016f\u0169\3\2"+
		"\2\2\u0170V\3\2\2\2\u0171\u0174\5_/\2\u0172\u0174\5a\60\2\u0173\u0171"+
		"\3\2\2\2\u0173\u0172\3\2\2\2\u0174\u017a\3\2\2\2\u0175\u0179\5_/\2\u0176"+
		"\u0179\5a\60\2\u0177\u0179\t\3\2\2\u0178\u0175\3\2\2\2\u0178\u0176\3\2"+
		"\2\2\u0178\u0177\3\2\2\2\u0179\u017c\3\2\2\2\u017a\u0178\3\2\2\2\u017a"+
		"\u017b\3\2\2\2\u017bX\3\2\2\2\u017c\u017a\3\2\2\2\u017d\u017f\t\4\2\2"+
		"\u017e\u017d\3\2\2\2\u017f\u0180\3\2\2\2\u0180\u017e\3\2\2\2\u0180\u0181"+
		"\3\2\2\2\u0181\u0182\3\2\2\2\u0182\u0183\b,\4\2\u0183Z\3\2\2\2\u0184\u0185"+
		"\7.\2\2\u0185\\\3\2\2\2\u0186\u0187\7^\2\2\u0187\u018b\7$\2\2\u0188\u0189"+
		"\7^\2\2\u0189\u018b\7^\2\2\u018a\u0186\3\2\2\2\u018a\u0188\3\2\2\2\u018b"+
		"^\3\2\2\2\u018c\u018d\t\5\2\2\u018d`\3\2\2\2\u018e\u018f\t\6\2\2\u018f"+
		"b\3\2\2\2\u0190\u0192\t\4\2\2\u0191\u0190\3\2\2\2\u0192\u0193\3\2\2\2"+
		"\u0193\u0191\3\2\2\2\u0193\u0194\3\2\2\2\u0194\u0195\3\2\2\2\u0195\u0196"+
		"\b\61\5\2\u0196d\3\2\2\2\u0197\u0198\7w\2\2\u0198\u0199\7u\2\2\u0199\u019a"+
		"\7g\2\2\u019a\u019b\7e\2\2\u019b\u019c\7c\2\2\u019c\u019d\7u\2\2\u019d"+
		"\u019e\7g\2\2\u019e\u019f\3\2\2\2\u019f\u01a0\b\62\6\2\u01a0f\3\2\2\2"+
		"\u01a1\u01a2\7u\2\2\u01a2\u01a3\7v\2\2\u01a3\u01a4\7c\2\2\u01a4\u01a5"+
		"\7v\2\2\u01a5\u01a6\7g\2\2\u01a6\u01a7\3\2\2\2\u01a7\u01a8\b\63\7\2\u01a8"+
		"h\3\2\2\2\u01a9\u01aa\7c\2\2\u01aa\u01ab\7e\2\2\u01ab\u01ac\7v\2\2\u01ac"+
		"\u01ad\7k\2\2\u01ad\u01ae\7q\2\2\u01ae\u01af\7p\2\2\u01af\u01b0\3\2\2"+
		"\2\u01b0\u01b1\b\64\b\2\u01b1j\3\2\2\2\u01b2\u01b3\7e\2\2\u01b3\u01b4"+
		"\7q\2\2\u01b4\u01b5\7p\2\2\u01b5\u01b6\7v\2\2\u01b6\u01b7\7g\2\2\u01b7"+
		"\u01b8\7z\2\2\u01b8\u01b9\7v\2\2\u01b9\u01ba\3\2\2\2\u01ba\u01bb\b\65"+
		"\t\2\u01bbl\3\2\2\2\u01bc\u01bd\7h\2\2\u01bd\u01be\7q\2\2\u01be\u01bf"+
		"\7t\2\2\u01bf\u01c0\7o\2\2\u01c0\u01c1\7w\2\2\u01c1\u01c2\7n\2\2\u01c2"+
		"\u01c3\7c\2\2\u01c3\u01c4\3\2\2\2\u01c4\u01c5\b\66\n\2\u01c5n\3\2\2\2"+
		"\u01c6\u01c7\7k\2\2\u01c7\u01c8\7o\2\2\u01c8\u01c9\7r\2\2\u01c9\u01ca"+
		"\7q\2\2\u01ca\u01cb\7t\2\2\u01cb\u01cc\7v\2\2\u01cc\u01cd\3\2\2\2\u01cd"+
		"\u01ce\b\67\13\2\u01cep\3\2\2\2\u01cf\u01d0\7p\2\2\u01d0\u01d1\7g\2\2"+
		"\u01d1\u01d2\7g\2\2\u01d2\u01d3\7f\2\2\u01d3\u01d4\7u\2\2\u01d4\u01d5"+
		"\3\2\2\2\u01d5\u01d6\b8\f\2\u01d6r\3\2\2\2\u01d7\u01d8\7i\2\2\u01d8\u01d9"+
		"\7t\2\2\u01d9\u01da\7q\2\2\u01da\u01db\7w\2\2\u01db\u01dc\7r\2\2\u01dc"+
		"\u01dd\3\2\2\2\u01dd\u01de\b9\r\2\u01det\3\2\2\2\u01df\u01e0\7d\2\2\u01e0"+
		"\u01e1\7t\2\2\u01e1\u01e2\7c\2\2\u01e2\u01e3\7p\2\2\u01e3\u01e4\7e\2\2"+
		"\u01e4\u01e5\7j\2\2\u01e5\u01e6\3\2\2\2\u01e6\u01e7\b:\16\2\u01e7v\3\2"+
		"\2\2\u01e8\u01e9\7f\2\2\u01e9\u01ea\7q\2\2\u01ea\u01eb\3\2\2\2\u01eb\u01ec"+
		"\b;\17\2\u01ecx\3\2\2\2\u01ed\u01ee\7f\2\2\u01ee\u01ef\7c\2\2\u01ef\u01f0"+
		"\7v\2\2\u01f0\u01f1\7c\2\2\u01f1\u01f2\3\2\2\2\u01f2\u01f3\b<\20\2\u01f3"+
		"z\3\2\2\2\u01f4\u01f5\7r\2\2\u01f5\u01f6\7t\2\2\u01f6\u01f7\7g\2\2\u01f7"+
		"\u01f8\7/\2\2\u01f8\u01f9\7e\2\2\u01f9\u01fa\7q\2\2\u01fa\u01fb\7p\2\2"+
		"\u01fb\u01fc\7f\2\2\u01fc\u01fd\7k\2\2\u01fd\u01fe\7v\2\2\u01fe\u01ff"+
		"\7k\2\2\u01ff\u0200\7q\2\2\u0200\u0201\7p\2\2\u0201\u0202\3\2\2\2\u0202"+
		"\u0203\b=\21\2\u0203|\3\2\2\2\u0204\u0205\7c\2\2\u0205\u0206\7e\2\2\u0206"+
		"\u0207\7v\2\2\u0207\u0208\7q\2\2\u0208\u0209\7t\2\2\u0209\u020a\7u\2\2"+
		"\u020a\u020b\3\2\2\2\u020b\u020c\b>\22\2\u020c~\3\2\2\2\u020d\u020e\7"+
		"d\2\2\u020e\u020f\7g\2\2\u020f\u0210\7h\2\2\u0210\u0211\7q\2\2\u0211\u0212"+
		"\7t\2\2\u0212\u0213\7g\2\2\u0213\u0214\3\2\2\2\u0214\u0215\b?\23\2\u0215"+
		"\u0080\3\2\2\2\u0216\u0217\7c\2\2\u0217\u0218\7h\2\2\u0218\u0219\7v\2"+
		"\2\u0219\u021a\7g\2\2\u021a\u021b\7t\2\2\u021b\u021c\3\2\2\2\u021c\u021d"+
		"\b@\24\2\u021d\u0082\3\2\2\2\u021e\u0220\t\7\2\2\u021f\u021e\3\2\2\2\u0220"+
		"\u0221\3\2\2\2\u0221\u021f\3\2\2\2\u0221\u0222\3\2\2\2\u0222\u0084\3\2"+
		"\2\2\u0223\u0226\5_/\2\u0224\u0226\5a\60\2\u0225\u0223\3\2\2\2\u0225\u0224"+
		"\3\2\2\2\u0226\u022c\3\2\2\2\u0227\u022b\5_/\2\u0228\u022b\5a\60\2\u0229"+
		"\u022b\t\3\2\2\u022a\u0227\3\2\2\2\u022a\u0228\3\2\2\2\u022a\u0229\3\2"+
		"\2\2\u022b\u022e\3\2\2\2\u022c\u022a\3\2\2\2\u022c\u022d\3\2\2\2\u022d"+
		"\u0086\3\2\2\2\u022e\u022c\3\2\2\2\u022f\u0231\t\b\2\2\u0230\u022f\3\2"+
		"\2\2\u0231\u0232\3\2\2\2\u0232\u0230\3\2\2\2\u0232\u0233\3\2\2\2\u0233"+
		"\u0234\3\2\2\2\u0234\u0235\bC\25\2\u0235\u0088\3\2\2\2\u0236\u0237\7_"+
		"\2\2\u0237\u0238\3\2\2\2\u0238\u0239\bD\26\2\u0239\u008a\3\2\2\2\35\2"+
		"\3\4\u008f\u0097\u009b\u009e\u011f\u014d\u0152\u0157\u0159\u0161\u0167"+
		"\u016d\u016f\u0173\u0178\u017a\u0180\u018a\u0193\u0221\u0225\u022a\u022c"+
		"\u0232";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}