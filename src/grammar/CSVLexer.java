// Generated from E:\clojure-install\generuse\src\grammar\CSV.g4 by ANTLR 4.1
package org.generuse.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CSVLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		CR=1, LF=2, COMMA=3, TAB=4, TEXT=5, STRING=6;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'\r'", "'\n'", "','", "'\t'", "TEXT", "STRING"
	};
	public static final String[] ruleNames = {
		"CR", "LF", "COMMA", "TAB", "TEXT", "STRING"
	};


	public CSVLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "CSV.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\b\'\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5"+
		"\3\6\6\6\31\n\6\r\6\16\6\32\3\7\3\7\3\7\3\7\7\7!\n\7\f\7\16\7$\13\7\3"+
		"\7\3\7\2\b\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\3\2\4\6\2\f\f\17\17$$"+
		"..\3\2$$)\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2"+
		"\2\r\3\2\2\2\3\17\3\2\2\2\5\21\3\2\2\2\7\23\3\2\2\2\t\25\3\2\2\2\13\30"+
		"\3\2\2\2\r\34\3\2\2\2\17\20\7\17\2\2\20\4\3\2\2\2\21\22\7\f\2\2\22\6\3"+
		"\2\2\2\23\24\7.\2\2\24\b\3\2\2\2\25\26\7\13\2\2\26\n\3\2\2\2\27\31\n\2"+
		"\2\2\30\27\3\2\2\2\31\32\3\2\2\2\32\30\3\2\2\2\32\33\3\2\2\2\33\f\3\2"+
		"\2\2\34\"\7$\2\2\35\36\7$\2\2\36!\7$\2\2\37!\n\3\2\2 \35\3\2\2\2 \37\3"+
		"\2\2\2!$\3\2\2\2\" \3\2\2\2\"#\3\2\2\2#%\3\2\2\2$\"\3\2\2\2%&\7$\2\2&"+
		"\16\3\2\2\2\6\2\32 \"";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}