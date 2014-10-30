// Generated from Generuse.g4 by ANTLR 4.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GeneruseParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LT=30, FORMULA=52, RC=7, ACTOR_WORD=64, RB=3, RP=5, MOD=22, LETTER=45, 
		GTE=31, LP=4, DIRECTIVE_NAME_WS=47, DO=57, EQUALS=25, FLOAT=41, NOT=28, 
		AND=26, LTE=32, ACTION=50, CONTEXT=51, WORD=42, AS=15, IMPORT=53, ACTOR_RB=66, 
		COMMA=44, IS=34, WAS=35, PLUS=23, DIGIT=46, COMMENT=1, BEFORE_DIRECTIVE=61, 
		STATE=49, AFTER_DIRECTIVE=62, ACTOR_SEP=63, PERIOD=8, MEMBER_SEP=9, BEFORE=12, 
		HAVING=11, INT=39, MINUS=24, BE=14, AFTER=13, GIVING=10, MUL=21, TRUE=18, 
		SEMI=17, MUST=36, PREPOSITION=38, COLON=16, GROUP=55, NEEDS=54, NEQ=33, 
		WS=43, USECASE=48, PRECONDITION=59, OR=27, ACTOR_WS=65, BRANCH=56, LC=6, 
		GT=29, LB=2, DIV=20, FALSE=19, DATA=58, ARTICLE=37, STRING=40, ACTORS=60;
	public static final String[] tokenNames = {
		"<INVALID>", "COMMENT", "'['", "RB", "'('", "')'", "'{'", "'}'", "'.'", 
		"''s'", "'giving'", "'having'", "BEFORE", "AFTER", "'be'", "'as'", "':'", 
		"';'", "'true'", "'false'", "'/'", "'*'", "'mod'", "'+'", "'-'", "'='", 
		"'and'", "'or'", "'not'", "'>'", "'<'", "'>='", "'<='", "'not='", "'is'", 
		"'was'", "'must'", "ARTICLE", "PREPOSITION", "INT", "STRING", "FLOAT", 
		"WORD", "WS", "','", "LETTER", "DIGIT", "DIRECTIVE_NAME_WS", "'usecase'", 
		"'state'", "'action'", "'context'", "'formula'", "'import'", "'needs'", 
		"'group'", "'branch'", "'do'", "'data'", "'pre-condition'", "'actors'", 
		"BEFORE_DIRECTIVE", "AFTER_DIRECTIVE", "ACTOR_SEP", "ACTOR_WORD", "ACTOR_WS", 
		"ACTOR_RB"
	};
	public static final int
		RULE_gss = 0, RULE_groupSpec = 1, RULE_importSpec = 2, RULE_usecase = 3, 
		RULE_usecased = 4, RULE_state = 5, RULE_action = 6, RULE_formula = 7, 
		RULE_data = 8, RULE_usecaseHeader = 9, RULE_usecasedHeader = 10, RULE_stateHeader = 11, 
		RULE_actionHeader = 12, RULE_formulaHeader = 13, RULE_dataHeader = 14, 
		RULE_stateSpec = 15, RULE_formalParams = 16, RULE_conj = 17, RULE_auxVerb = 18, 
		RULE_id = 19, RULE_actorId = 20, RULE_objectSpec = 21, RULE_instantSpec = 22, 
		RULE_usecaseId = 23, RULE_contextSpec = 24, RULE_attributeValue = 25, 
		RULE_actorSpec = 26, RULE_preconditionSpec = 27, RULE_doSpec = 28, RULE_command = 29, 
		RULE_branchSpec = 30, RULE_sentence = 31, RULE_objRefEx = 32, RULE_expr = 33, 
		RULE_literal = 34, RULE_stmt = 35, RULE_actionId = 36, RULE_actionSuffix = 37, 
		RULE_resultId = 38, RULE_pastSpec = 39, RULE_timeSpec = 40, RULE_noteSpec = 41, 
		RULE_notePrefix = 42, RULE_noteSuffix = 43, RULE_multiParamSpec = 44, 
		RULE_autoParam = 45, RULE_paramName = 46, RULE_objRef = 47, RULE_objField = 48;
	public static final String[] ruleNames = {
		"gss", "groupSpec", "importSpec", "usecase", "usecased", "state", "action", 
		"formula", "data", "usecaseHeader", "usecasedHeader", "stateHeader", "actionHeader", 
		"formulaHeader", "dataHeader", "stateSpec", "formalParams", "conj", "auxVerb", 
		"id", "actorId", "objectSpec", "instantSpec", "usecaseId", "contextSpec", 
		"attributeValue", "actorSpec", "preconditionSpec", "doSpec", "command", 
		"branchSpec", "sentence", "objRefEx", "expr", "literal", "stmt", "actionId", 
		"actionSuffix", "resultId", "pastSpec", "timeSpec", "noteSpec", "notePrefix", 
		"noteSuffix", "multiParamSpec", "autoParam", "paramName", "objRef", "objField"
	};

	@Override
	public String getGrammarFileName() { return "Generuse.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public GeneruseParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class GssContext extends ParserRuleContext {
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public GroupSpecContext groupSpec() {
			return getRuleContext(GroupSpecContext.class,0);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public List<ActionContext> action() {
			return getRuleContexts(ActionContext.class);
		}
		public List<StateContext> state() {
			return getRuleContexts(StateContext.class);
		}
		public StateContext state(int i) {
			return getRuleContext(StateContext.class,i);
		}
		public DataContext data(int i) {
			return getRuleContext(DataContext.class,i);
		}
		public ActionContext action(int i) {
			return getRuleContext(ActionContext.class,i);
		}
		public UsecaseContext usecase(int i) {
			return getRuleContext(UsecaseContext.class,i);
		}
		public List<DataContext> data() {
			return getRuleContexts(DataContext.class);
		}
		public List<UsecasedContext> usecased() {
			return getRuleContexts(UsecasedContext.class);
		}
		public UsecasedContext usecased(int i) {
			return getRuleContext(UsecasedContext.class,i);
		}
		public List<ImportSpecContext> importSpec() {
			return getRuleContexts(ImportSpecContext.class);
		}
		public List<UsecaseContext> usecase() {
			return getRuleContexts(UsecaseContext.class);
		}
		public ImportSpecContext importSpec(int i) {
			return getRuleContext(ImportSpecContext.class,i);
		}
		public GssContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gss; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).enterGss(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).exitGss(this);
		}
	}

	public final GssContext gss() throws RecognitionException {
		GssContext _localctx = new GssContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_gss);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(98); groupSpec();
			setState(102);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(99); importSpec();
					}
					} 
				}
				setState(104);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LB) {
				{
				setState(111);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					setState(105); usecase();
					}
					break;

				case 2:
					{
					setState(106); usecased();
					}
					break;

				case 3:
					{
					setState(107); state();
					}
					break;

				case 4:
					{
					setState(108); action();
					}
					break;

				case 5:
					{
					setState(109); formula();
					}
					break;

				case 6:
					{
					setState(110); data();
					}
					break;
				}
				}
				setState(115);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GroupSpecContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode LB() { return getToken(GeneruseParser.LB, 0); }
		public TerminalNode RB() { return getToken(GeneruseParser.RB, 0); }
		public TerminalNode GROUP() { return getToken(GeneruseParser.GROUP, 0); }
		public GroupSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groupSpec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).enterGroupSpec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).exitGroupSpec(this);
		}
	}

	public final GroupSpecContext groupSpec() throws RecognitionException {
		GroupSpecContext _localctx = new GroupSpecContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_groupSpec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116); match(LB);
			setState(117); match(GROUP);
			setState(118); id();
			setState(119); match(RB);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ImportSpecContext extends ParserRuleContext {
		public AttributeValueContext attributeValue(int i) {
			return getRuleContext(AttributeValueContext.class,i);
		}
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode LB() { return getToken(GeneruseParser.LB, 0); }
		public List<AttributeValueContext> attributeValue() {
			return getRuleContexts(AttributeValueContext.class);
		}
		public TerminalNode IMPORT() { return getToken(GeneruseParser.IMPORT, 0); }
		public TerminalNode RB() { return getToken(GeneruseParser.RB, 0); }
		public ImportSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importSpec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).enterImportSpec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).exitImportSpec(this);
		}
	}

	public final ImportSpecContext importSpec() throws RecognitionException {
		ImportSpecContext _localctx = new ImportSpecContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_importSpec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121); match(LB);
			setState(122); match(IMPORT);
			setState(123); id();
			setState(127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WORD) {
				{
				{
				setState(124); attributeValue();
				}
				}
				setState(129);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(130); match(RB);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UsecaseContext extends ParserRuleContext {
		public List<CommandContext> command() {
			return getRuleContexts(CommandContext.class);
		}
		public PreconditionSpecContext preconditionSpec() {
			return getRuleContext(PreconditionSpecContext.class,0);
		}
		public UsecaseHeaderContext usecaseHeader() {
			return getRuleContext(UsecaseHeaderContext.class,0);
		}
		public ActorSpecContext actorSpec() {
			return getRuleContext(ActorSpecContext.class,0);
		}
		public CommandContext command(int i) {
			return getRuleContext(CommandContext.class,i);
		}
		public UsecaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_usecase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).enterUsecase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).exitUsecase(this);
		}
	}

	public final UsecaseContext usecase() throws RecognitionException {
		UsecaseContext _localctx = new UsecaseContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_usecase);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(132); usecaseHeader();
			setState(134);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(133); preconditionSpec();
				}
				break;
			}
			setState(136); actorSpec();
			setState(140);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(137); command();
					}
					} 
				}
				setState(142);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UsecasedContext extends ParserRuleContext {
		public List<CommandContext> command() {
			return getRuleContexts(CommandContext.class);
		}
		public ActorSpecContext actorSpec() {
			return getRuleContext(ActorSpecContext.class,0);
		}
		public UsecasedHeaderContext usecasedHeader() {
			return getRuleContext(UsecasedHeaderContext.class,0);
		}
		public CommandContext command(int i) {
			return getRuleContext(CommandContext.class,i);
		}
		public UsecasedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_usecased; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).enterUsecased(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).exitUsecased(this);
		}
	}

	public final UsecasedContext usecased() throws RecognitionException {
		UsecasedContext _localctx = new UsecasedContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_usecased);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(143); usecasedHeader();
			setState(144); actorSpec();
			setState(148);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(145); command();
					}
					} 
				}
				setState(150);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StateContext extends ParserRuleContext {
		public StateHeaderContext stateHeader() {
			return getRuleContext(StateHeaderContext.class,0);
		}
		public List<SentenceContext> sentence() {
			return getRuleContexts(SentenceContext.class);
		}
		public InstantSpecContext instantSpec(int i) {
			return getRuleContext(InstantSpecContext.class,i);
		}
		public SentenceContext sentence(int i) {
			return getRuleContext(SentenceContext.class,i);
		}
		public List<InstantSpecContext> instantSpec() {
			return getRuleContexts(InstantSpecContext.class);
		}
		public StateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_state; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).enterState(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).exitState(this);
		}
	}

	public final StateContext state() throws RecognitionException {
		StateContext _localctx = new StateContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_state);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151); stateHeader();
			setState(153); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(152); instantSpec();
				}
				}
				setState(155); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==LB );
			setState(158); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(157); sentence();
				}
				}
				setState(160); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LP) | (1L << PERIOD) | (1L << TRUE) | (1L << FALSE) | (1L << MINUS) | (1L << NOT) | (1L << ARTICLE) | (1L << INT) | (1L << STRING) | (1L << FLOAT) | (1L << WORD))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ActionContext extends ParserRuleContext {
		public List<SentenceContext> sentence() {
			return getRuleContexts(SentenceContext.class);
		}
		public SentenceContext sentence(int i) {
			return getRuleContext(SentenceContext.class,i);
		}
		public ActionHeaderContext actionHeader() {
			return getRuleContext(ActionHeaderContext.class,0);
		}
		public ObjectSpecContext objectSpec() {
			return getRuleContext(ObjectSpecContext.class,0);
		}
		public ActionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_action; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).enterAction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).exitAction(this);
		}
	}

	public final ActionContext action() throws RecognitionException {
		ActionContext _localctx = new ActionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_action);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162); actionHeader();
			setState(163); objectSpec();
			setState(165); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(164); sentence();
				}
				}
				setState(167); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LP) | (1L << PERIOD) | (1L << TRUE) | (1L << FALSE) | (1L << MINUS) | (1L << NOT) | (1L << ARTICLE) | (1L << INT) | (1L << STRING) | (1L << FLOAT) | (1L << WORD))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormulaContext extends ParserRuleContext {
		public List<SentenceContext> sentence() {
			return getRuleContexts(SentenceContext.class);
		}
		public SentenceContext sentence(int i) {
			return getRuleContext(SentenceContext.class,i);
		}
		public FormulaHeaderContext formulaHeader() {
			return getRuleContext(FormulaHeaderContext.class,0);
		}
		public FormulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formula; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).enterFormula(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).exitFormula(this);
		}
	}

	public final FormulaContext formula() throws RecognitionException {
		FormulaContext _localctx = new FormulaContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_formula);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169); formulaHeader();
			setState(171); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(170); sentence();
				}
				}
				setState(173); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LP) | (1L << PERIOD) | (1L << TRUE) | (1L << FALSE) | (1L << MINUS) | (1L << NOT) | (1L << ARTICLE) | (1L << INT) | (1L << STRING) | (1L << FLOAT) | (1L << WORD))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DataContext extends ParserRuleContext {
		public List<SentenceContext> sentence() {
			return getRuleContexts(SentenceContext.class);
		}
		public DataHeaderContext dataHeader() {
			return getRuleContext(DataHeaderContext.class,0);
		}
		public SentenceContext sentence(int i) {
			return getRuleContext(SentenceContext.class,i);
		}
		public DataContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_data; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).enterData(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).exitData(this);
		}
	}

	public final DataContext data() throws RecognitionException {
		DataContext _localctx = new DataContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_data);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175); dataHeader();
			setState(177); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(176); sentence();
				}
				}
				setState(179); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LP) | (1L << PERIOD) | (1L << TRUE) | (1L << FALSE) | (1L << MINUS) | (1L << NOT) | (1L << ARTICLE) | (1L << INT) | (1L << STRING) | (1L << FLOAT) | (1L << WORD))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UsecaseHeaderContext extends ParserRuleContext {
		public AttributeValueContext attributeValue(int i) {
			return getRuleContext(AttributeValueContext.class,i);
		}
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode LB() { return getToken(GeneruseParser.LB, 0); }
		public List<AttributeValueContext> attributeValue() {
			return getRuleContexts(AttributeValueContext.class);
		}
		public TerminalNode HAVING() { return getToken(GeneruseParser.HAVING, 0); }
		public TerminalNode USECASE() { return getToken(GeneruseParser.USECASE, 0); }
		public TerminalNode RB() { return getToken(GeneruseParser.RB, 0); }
		public UsecaseHeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_usecaseHeader; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).enterUsecaseHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).exitUsecaseHeader(this);
		}
	}

	public final UsecaseHeaderContext usecaseHeader() throws RecognitionException {
		UsecaseHeaderContext _localctx = new UsecaseHeaderContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_usecaseHeader);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181); match(LB);
			setState(182); match(USECASE);
			setState(183); id();
			setState(190);
			_la = _input.LA(1);
			if (_la==HAVING) {
				{
				setState(184); match(HAVING);
				setState(186); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(185); attributeValue();
					}
					}
					setState(188); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==WORD );
				}
			}

			setState(192); match(RB);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UsecasedHeaderContext extends ParserRuleContext {
		public AttributeValueContext attributeValue(int i) {
			return getRuleContext(AttributeValueContext.class,i);
		}
		public FormalParamsContext formalParams() {
			return getRuleContext(FormalParamsContext.class,0);
		}
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode LB() { return getToken(GeneruseParser.LB, 0); }
		public List<AttributeValueContext> attributeValue() {
			return getRuleContexts(AttributeValueContext.class);
		}
		public TerminalNode HAVING() { return getToken(GeneruseParser.HAVING, 0); }
		public TerminalNode USECASE() { return getToken(GeneruseParser.USECASE, 0); }
		public TerminalNode RB() { return getToken(GeneruseParser.RB, 0); }
		public TerminalNode MINUS() { return getToken(GeneruseParser.MINUS, 0); }
		public UsecasedHeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_usecasedHeader; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).enterUsecasedHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).exitUsecasedHeader(this);
		}
	}

	public final UsecasedHeaderContext usecasedHeader() throws RecognitionException {
		UsecasedHeaderContext _localctx = new UsecasedHeaderContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_usecasedHeader);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194); match(LB);
			setState(195); match(USECASE);
			setState(196); id();
			setState(199);
			switch (_input.LA(1)) {
			case MINUS:
				{
				setState(197); match(MINUS);
				}
				break;
			case PREPOSITION:
				{
				setState(198); formalParams();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(207);
			_la = _input.LA(1);
			if (_la==HAVING) {
				{
				setState(201); match(HAVING);
				setState(203); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(202); attributeValue();
					}
					}
					setState(205); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==WORD );
				}
			}

			setState(209); match(RB);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StateHeaderContext extends ParserRuleContext {
		public AttributeValueContext attributeValue(int i) {
			return getRuleContext(AttributeValueContext.class,i);
		}
		public TerminalNode LB() { return getToken(GeneruseParser.LB, 0); }
		public List<AttributeValueContext> attributeValue() {
			return getRuleContexts(AttributeValueContext.class);
		}
		public TerminalNode STATE() { return getToken(GeneruseParser.STATE, 0); }
		public TerminalNode HAVING() { return getToken(GeneruseParser.HAVING, 0); }
		public TerminalNode RB() { return getToken(GeneruseParser.RB, 0); }
		public StateSpecContext stateSpec() {
			return getRuleContext(StateSpecContext.class,0);
		}
		public StateHeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stateHeader; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).enterStateHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).exitStateHeader(this);
		}
	}

	public final StateHeaderContext stateHeader() throws RecognitionException {
		StateHeaderContext _localctx = new StateHeaderContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_stateHeader);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211); match(LB);
			setState(212); match(STATE);
			setState(213); stateSpec();
			setState(220);
			_la = _input.LA(1);
			if (_la==HAVING) {
				{
				setState(214); match(HAVING);
				setState(216); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(215); attributeValue();
					}
					}
					setState(218); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==WORD );
				}
			}

			setState(222); match(RB);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ActionHeaderContext extends ParserRuleContext {
		public AttributeValueContext attributeValue(int i) {
			return getRuleContext(AttributeValueContext.class,i);
		}
		public FormalParamsContext formalParams() {
			return getRuleContext(FormalParamsContext.class,0);
		}
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode LB() { return getToken(GeneruseParser.LB, 0); }
		public List<AttributeValueContext> attributeValue() {
			return getRuleContexts(AttributeValueContext.class);
		}
		public TerminalNode ACTION() { return getToken(GeneruseParser.ACTION, 0); }
		public TerminalNode HAVING() { return getToken(GeneruseParser.HAVING, 0); }
		public TerminalNode RB() { return getToken(GeneruseParser.RB, 0); }
		public ActionSuffixContext actionSuffix() {
			return getRuleContext(ActionSuffixContext.class,0);
		}
		public ActionHeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actionHeader; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).enterActionHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).exitActionHeader(this);
		}
	}

	public final ActionHeaderContext actionHeader() throws RecognitionException {
		ActionHeaderContext _localctx = new ActionHeaderContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_actionHeader);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224); match(LB);
			setState(225); match(ACTION);
			setState(226); id();
			setState(228);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(227); actionSuffix();
				}
				break;
			}
			setState(231);
			_la = _input.LA(1);
			if (_la==PREPOSITION) {
				{
				setState(230); formalParams();
				}
			}

			setState(239);
			_la = _input.LA(1);
			if (_la==HAVING) {
				{
				setState(233); match(HAVING);
				setState(235); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(234); attributeValue();
					}
					}
					setState(237); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==WORD );
				}
			}

			setState(241); match(RB);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormulaHeaderContext extends ParserRuleContext {
		public AttributeValueContext attributeValue(int i) {
			return getRuleContext(AttributeValueContext.class,i);
		}
		public FormalParamsContext formalParams() {
			return getRuleContext(FormalParamsContext.class,0);
		}
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode LB() { return getToken(GeneruseParser.LB, 0); }
		public List<AttributeValueContext> attributeValue() {
			return getRuleContexts(AttributeValueContext.class);
		}
		public TerminalNode HAVING() { return getToken(GeneruseParser.HAVING, 0); }
		public TerminalNode RB() { return getToken(GeneruseParser.RB, 0); }
		public TerminalNode FORMULA() { return getToken(GeneruseParser.FORMULA, 0); }
		public FormulaHeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formulaHeader; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).enterFormulaHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).exitFormulaHeader(this);
		}
	}

	public final FormulaHeaderContext formulaHeader() throws RecognitionException {
		FormulaHeaderContext _localctx = new FormulaHeaderContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_formulaHeader);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243); match(LB);
			setState(244); match(FORMULA);
			setState(245); id();
			setState(247);
			_la = _input.LA(1);
			if (_la==PREPOSITION) {
				{
				setState(246); formalParams();
				}
			}

			setState(255);
			_la = _input.LA(1);
			if (_la==HAVING) {
				{
				setState(249); match(HAVING);
				setState(251); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(250); attributeValue();
					}
					}
					setState(253); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==WORD );
				}
			}

			setState(257); match(RB);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DataHeaderContext extends ParserRuleContext {
		public AttributeValueContext attributeValue(int i) {
			return getRuleContext(AttributeValueContext.class,i);
		}
		public TerminalNode LB() { return getToken(GeneruseParser.LB, 0); }
		public ObjRefContext objRef() {
			return getRuleContext(ObjRefContext.class,0);
		}
		public List<AttributeValueContext> attributeValue() {
			return getRuleContexts(AttributeValueContext.class);
		}
		public TerminalNode DATA() { return getToken(GeneruseParser.DATA, 0); }
		public TerminalNode RB() { return getToken(GeneruseParser.RB, 0); }
		public DataHeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataHeader; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).enterDataHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).exitDataHeader(this);
		}
	}

	public final DataHeaderContext dataHeader() throws RecognitionException {
		DataHeaderContext _localctx = new DataHeaderContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_dataHeader);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259); match(LB);
			setState(260); match(DATA);
			setState(261); objRef();
			setState(265);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WORD) {
				{
				{
				setState(262); attributeValue();
				}
				}
				setState(267);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(268); match(RB);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StateSpecContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode BEFORE() { return getToken(GeneruseParser.BEFORE, 0); }
		public TerminalNode AFTER() { return getToken(GeneruseParser.AFTER, 0); }
		public StateSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stateSpec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).enterStateSpec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).exitStateSpec(this);
		}
	}

	public final StateSpecContext stateSpec() throws RecognitionException {
		StateSpecContext _localctx = new StateSpecContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_stateSpec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			_la = _input.LA(1);
			if ( !(_la==BEFORE || _la==AFTER) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(271); id();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormalParamsContext extends ParserRuleContext {
		public List<IdContext> id() {
			return getRuleContexts(IdContext.class);
		}
		public ConjContext conj(int i) {
			return getRuleContext(ConjContext.class,i);
		}
		public List<ConjContext> conj() {
			return getRuleContexts(ConjContext.class);
		}
		public TerminalNode PREPOSITION() { return getToken(GeneruseParser.PREPOSITION, 0); }
		public IdContext id(int i) {
			return getRuleContext(IdContext.class,i);
		}
		public TerminalNode ARTICLE(int i) {
			return getToken(GeneruseParser.ARTICLE, i);
		}
		public List<TerminalNode> ARTICLE() { return getTokens(GeneruseParser.ARTICLE); }
		public FormalParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParams; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).enterFormalParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).exitFormalParams(this);
		}
	}

	public final FormalParamsContext formalParams() throws RecognitionException {
		FormalParamsContext _localctx = new FormalParamsContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_formalParams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(273); match(PREPOSITION);
			setState(275);
			_la = _input.LA(1);
			if (_la==ARTICLE) {
				{
				setState(274); match(ARTICLE);
				}
			}

			setState(277); id();
			setState(286);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND || _la==COMMA) {
				{
				{
				setState(278); conj();
				setState(280);
				_la = _input.LA(1);
				if (_la==ARTICLE) {
					{
					setState(279); match(ARTICLE);
					}
				}

				setState(282); id();
				}
				}
				setState(288);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConjContext extends ParserRuleContext {
		public List<TerminalNode> AND() { return getTokens(GeneruseParser.AND); }
		public List<TerminalNode> COMMA() { return getTokens(GeneruseParser.COMMA); }
		public TerminalNode AND(int i) {
			return getToken(GeneruseParser.AND, i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(GeneruseParser.COMMA, i);
		}
		public ConjContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conj; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).enterConj(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).exitConj(this);
		}
	}

	public final ConjContext conj() throws RecognitionException {
		ConjContext _localctx = new ConjContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_conj);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(290); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(289);
				_la = _input.LA(1);
				if ( !(_la==AND || _la==COMMA) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				}
				setState(292); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==AND || _la==COMMA );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AuxVerbContext extends ParserRuleContext {
		public TerminalNode MUST() { return getToken(GeneruseParser.MUST, 0); }
		public TerminalNode NOT() { return getToken(GeneruseParser.NOT, 0); }
		public TerminalNode BE() { return getToken(GeneruseParser.BE, 0); }
		public TerminalNode WAS() { return getToken(GeneruseParser.WAS, 0); }
		public TerminalNode IS() { return getToken(GeneruseParser.IS, 0); }
		public AuxVerbContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_auxVerb; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).enterAuxVerb(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).exitAuxVerb(this);
		}
	}

	public final AuxVerbContext auxVerb() throws RecognitionException {
		AuxVerbContext _localctx = new AuxVerbContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_auxVerb);
		int _la;
		try {
			setState(306);
			switch (_input.LA(1)) {
			case IS:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(294); match(IS);
				setState(296);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(295); match(NOT);
					}
				}

				}
				}
				break;
			case WAS:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(298); match(WAS);
				setState(300);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(299); match(NOT);
					}
				}

				}
				}
				break;
			case MUST:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(302); match(MUST);
				setState(304);
				_la = _input.LA(1);
				if (_la==BE) {
					{
					setState(303); match(BE);
					}
				}

				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdContext extends ParserRuleContext {
		public List<TerminalNode> WORD() { return getTokens(GeneruseParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(GeneruseParser.WORD, i);
		}
		public IdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).enterId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).exitId(this);
		}
	}

	public final IdContext id() throws RecognitionException {
		IdContext _localctx = new IdContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_id);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(309); 
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(308); match(WORD);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(311); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			} while ( _alt!=2 && _alt!=-1 );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ActorIdContext extends ParserRuleContext {
		public TerminalNode ACTOR_WORD(int i) {
			return getToken(GeneruseParser.ACTOR_WORD, i);
		}
		public List<TerminalNode> ACTOR_WORD() { return getTokens(GeneruseParser.ACTOR_WORD); }
		public ActorIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actorId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).enterActorId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).exitActorId(this);
		}
	}

	public final ActorIdContext actorId() throws RecognitionException {
		ActorIdContext _localctx = new ActorIdContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_actorId);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(314); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(313); match(ACTOR_WORD);
				}
				}
				setState(316); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ACTOR_WORD );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ObjectSpecContext extends ParserRuleContext {
		public List<ContextSpecContext> contextSpec() {
			return getRuleContexts(ContextSpecContext.class);
		}
		public TerminalNode AS() { return getToken(GeneruseParser.AS, 0); }
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode LB() { return getToken(GeneruseParser.LB, 0); }
		public TerminalNode CONTEXT() { return getToken(GeneruseParser.CONTEXT, 0); }
		public ContextSpecContext contextSpec(int i) {
			return getRuleContext(ContextSpecContext.class,i);
		}
		public TerminalNode RB() { return getToken(GeneruseParser.RB, 0); }
		public TerminalNode LP() { return getToken(GeneruseParser.LP, 0); }
		public TerminalNode RP() { return getToken(GeneruseParser.RP, 0); }
		public ObjectSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectSpec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).enterObjectSpec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).exitObjectSpec(this);
		}
	}

	public final ObjectSpecContext objectSpec() throws RecognitionException {
		ObjectSpecContext _localctx = new ObjectSpecContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_objectSpec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(318); match(LB);
			setState(319); match(CONTEXT);
			setState(323);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WORD) {
				{
				{
				setState(320); contextSpec();
				}
				}
				setState(325);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(326); match(LP);
			setState(327); match(AS);
			setState(328); id();
			setState(329); match(RP);
			setState(330); match(RB);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InstantSpecContext extends ParserRuleContext {
		public UsecaseIdContext usecaseId() {
			return getRuleContext(UsecaseIdContext.class,0);
		}
		public TerminalNode BEFORE_DIRECTIVE() { return getToken(GeneruseParser.BEFORE_DIRECTIVE, 0); }
		public TerminalNode LB() { return getToken(GeneruseParser.LB, 0); }
		public TerminalNode AFTER_DIRECTIVE() { return getToken(GeneruseParser.AFTER_DIRECTIVE, 0); }
		public TerminalNode RB() { return getToken(GeneruseParser.RB, 0); }
		public TerminalNode PREPOSITION() { return getToken(GeneruseParser.PREPOSITION, 0); }
		public PastSpecContext pastSpec() {
			return getRuleContext(PastSpecContext.class,0);
		}
		public InstantSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instantSpec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).enterInstantSpec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).exitInstantSpec(this);
		}
	}

	public final InstantSpecContext instantSpec() throws RecognitionException {
		InstantSpecContext _localctx = new InstantSpecContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_instantSpec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(332); match(LB);
			setState(333);
			_la = _input.LA(1);
			if ( !(_la==BEFORE_DIRECTIVE || _la==AFTER_DIRECTIVE) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(334); pastSpec();
			setState(335); match(PREPOSITION);
			setState(336); usecaseId();
			setState(337); match(RB);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UsecaseIdContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public UsecaseIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_usecaseId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).enterUsecaseId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).exitUsecaseId(this);
		}
	}

	public final UsecaseIdContext usecaseId() throws RecognitionException {
		UsecaseIdContext _localctx = new UsecaseIdContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_usecaseId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(339); id();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ContextSpecContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public ObjRefContext objRef() {
			return getRuleContext(ObjRefContext.class,0);
		}
		public TerminalNode LP() { return getToken(GeneruseParser.LP, 0); }
		public TerminalNode RP() { return getToken(GeneruseParser.RP, 0); }
		public TerminalNode COLON() { return getToken(GeneruseParser.COLON, 0); }
		public ContextSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_contextSpec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).enterContextSpec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).exitContextSpec(this);
		}
	}

	public final ContextSpecContext contextSpec() throws RecognitionException {
		ContextSpecContext _localctx = new ContextSpecContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_contextSpec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(341); id();
			setState(342); match(COLON);
			setState(343); match(LP);
			setState(344); objRef();
			setState(345); match(RP);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttributeValueContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode STRING() { return getToken(GeneruseParser.STRING, 0); }
		public TerminalNode COLON() { return getToken(GeneruseParser.COLON, 0); }
		public AttributeValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributeValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).enterAttributeValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).exitAttributeValue(this);
		}
	}

	public final AttributeValueContext attributeValue() throws RecognitionException {
		AttributeValueContext _localctx = new AttributeValueContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_attributeValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(347); id();
			setState(348); match(COLON);
			setState(349); match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ActorSpecContext extends ParserRuleContext {
		public ActorIdContext actorId(int i) {
			return getRuleContext(ActorIdContext.class,i);
		}
		public TerminalNode LB() { return getToken(GeneruseParser.LB, 0); }
		public TerminalNode ACTORS() { return getToken(GeneruseParser.ACTORS, 0); }
		public TerminalNode ACTOR_SEP(int i) {
			return getToken(GeneruseParser.ACTOR_SEP, i);
		}
		public TerminalNode ACTOR_RB() { return getToken(GeneruseParser.ACTOR_RB, 0); }
		public List<TerminalNode> ACTOR_SEP() { return getTokens(GeneruseParser.ACTOR_SEP); }
		public List<ActorIdContext> actorId() {
			return getRuleContexts(ActorIdContext.class);
		}
		public ActorSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actorSpec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).enterActorSpec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).exitActorSpec(this);
		}
	}

	public final ActorSpecContext actorSpec() throws RecognitionException {
		ActorSpecContext _localctx = new ActorSpecContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_actorSpec);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(351); match(LB);
			setState(352); match(ACTORS);
			setState(354);
			_la = _input.LA(1);
			if (_la==ACTOR_SEP) {
				{
				setState(353); match(ACTOR_SEP);
				}
			}

			setState(356); actorId();
			setState(361);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(357); match(ACTOR_SEP);
					setState(358); actorId();
					}
					} 
				}
				setState(363);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
			}
			setState(365);
			_la = _input.LA(1);
			if (_la==ACTOR_SEP) {
				{
				setState(364); match(ACTOR_SEP);
				}
			}

			setState(367); match(ACTOR_RB);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PreconditionSpecContext extends ParserRuleContext {
		public TerminalNode LB() { return getToken(GeneruseParser.LB, 0); }
		public TerminalNode PRECONDITION() { return getToken(GeneruseParser.PRECONDITION, 0); }
		public TerminalNode RB() { return getToken(GeneruseParser.RB, 0); }
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public PreconditionSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_preconditionSpec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).enterPreconditionSpec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).exitPreconditionSpec(this);
		}
	}

	public final PreconditionSpecContext preconditionSpec() throws RecognitionException {
		PreconditionSpecContext _localctx = new PreconditionSpecContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_preconditionSpec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(369); match(LB);
			setState(370); match(PRECONDITION);
			setState(371); stmt();
			setState(372); match(RB);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DoSpecContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode LB() { return getToken(GeneruseParser.LB, 0); }
		public TerminalNode DO() { return getToken(GeneruseParser.DO, 0); }
		public TerminalNode RB() { return getToken(GeneruseParser.RB, 0); }
		public MultiParamSpecContext multiParamSpec() {
			return getRuleContext(MultiParamSpecContext.class,0);
		}
		public DoSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doSpec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).enterDoSpec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).exitDoSpec(this);
		}
	}

	public final DoSpecContext doSpec() throws RecognitionException {
		DoSpecContext _localctx = new DoSpecContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_doSpec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(374); match(LB);
			setState(375); match(DO);
			setState(376); id();
			setState(378);
			_la = _input.LA(1);
			if (_la==PREPOSITION) {
				{
				setState(377); multiParamSpec();
				}
			}

			setState(380); match(RB);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CommandContext extends ParserRuleContext {
		public SentenceContext sentence() {
			return getRuleContext(SentenceContext.class,0);
		}
		public DoSpecContext doSpec() {
			return getRuleContext(DoSpecContext.class,0);
		}
		public BranchSpecContext branchSpec() {
			return getRuleContext(BranchSpecContext.class,0);
		}
		public CommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_command; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).enterCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).exitCommand(this);
		}
	}

	public final CommandContext command() throws RecognitionException {
		CommandContext _localctx = new CommandContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_command);
		try {
			setState(385);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(382); sentence();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(383); doSpec();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(384); branchSpec();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BranchSpecContext extends ParserRuleContext {
		public TerminalNode LB() { return getToken(GeneruseParser.LB, 0); }
		public TerminalNode RB() { return getToken(GeneruseParser.RB, 0); }
		public TerminalNode BRANCH() { return getToken(GeneruseParser.BRANCH, 0); }
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public BranchSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_branchSpec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).enterBranchSpec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).exitBranchSpec(this);
		}
	}

	public final BranchSpecContext branchSpec() throws RecognitionException {
		BranchSpecContext _localctx = new BranchSpecContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_branchSpec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(387); match(LB);
			setState(388); match(BRANCH);
			setState(390);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LP) | (1L << TRUE) | (1L << FALSE) | (1L << MINUS) | (1L << NOT) | (1L << ARTICLE) | (1L << INT) | (1L << STRING) | (1L << FLOAT) | (1L << WORD))) != 0)) {
				{
				setState(389); stmt();
				}
			}

			setState(392); match(RB);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SentenceContext extends ParserRuleContext {
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public List<TerminalNode> SEMI() { return getTokens(GeneruseParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(GeneruseParser.SEMI, i);
		}
		public TerminalNode PERIOD() { return getToken(GeneruseParser.PERIOD, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public SentenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).enterSentence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).exitSentence(this);
		}
	}

	public final SentenceContext sentence() throws RecognitionException {
		SentenceContext _localctx = new SentenceContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_sentence);
		int _la;
		try {
			setState(405);
			switch (_input.LA(1)) {
			case LP:
			case TRUE:
			case FALSE:
			case MINUS:
			case NOT:
			case ARTICLE:
			case INT:
			case STRING:
			case FLOAT:
			case WORD:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(394); stmt();
				setState(399);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SEMI) {
					{
					{
					setState(395); match(SEMI);
					setState(396); stmt();
					}
					}
					setState(401);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(402); match(PERIOD);
				}
				}
				break;
			case PERIOD:
				enterOuterAlt(_localctx, 2);
				{
				setState(404); match(PERIOD);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ObjRefExContext extends ParserRuleContext {
		public ObjRefContext objRef() {
			return getRuleContext(ObjRefContext.class,0);
		}
		public StateSpecContext stateSpec() {
			return getRuleContext(StateSpecContext.class,0);
		}
		public ObjRefExContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objRefEx; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).enterObjRefEx(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).exitObjRefEx(this);
		}
	}

	public final ObjRefExContext objRefEx() throws RecognitionException {
		ObjRefExContext _localctx = new ObjRefExContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_objRefEx);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(407); objRef();
			setState(409);
			switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
			case 1:
				{
				setState(408); stateSpec();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public int _p;
		public Token op;
		public ObjRefExContext objRefEx() {
			return getRuleContext(ObjRefExContext.class,0);
		}
		public TerminalNode GTE() { return getToken(GeneruseParser.GTE, 0); }
		public TerminalNode MUL() { return getToken(GeneruseParser.MUL, 0); }
		public TerminalNode EQUALS() { return getToken(GeneruseParser.EQUALS, 0); }
		public TerminalNode AND() { return getToken(GeneruseParser.AND, 0); }
		public TerminalNode LP() { return getToken(GeneruseParser.LP, 0); }
		public TerminalNode OR() { return getToken(GeneruseParser.OR, 0); }
		public TerminalNode LTE() { return getToken(GeneruseParser.LTE, 0); }
		public TerminalNode MINUS() { return getToken(GeneruseParser.MINUS, 0); }
		public TerminalNode RP() { return getToken(GeneruseParser.RP, 0); }
		public TerminalNode NEQ() { return getToken(GeneruseParser.NEQ, 0); }
		public TerminalNode DIV() { return getToken(GeneruseParser.DIV, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public TerminalNode LT() { return getToken(GeneruseParser.LT, 0); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode NOT() { return getToken(GeneruseParser.NOT, 0); }
		public TerminalNode PLUS() { return getToken(GeneruseParser.PLUS, 0); }
		public TerminalNode GT() { return getToken(GeneruseParser.GT, 0); }
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public TerminalNode MOD() { return getToken(GeneruseParser.MOD, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ExprContext(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState, _p);
		ExprContext _prevctx = _localctx;
		int _startState = 66;
		enterRecursionRule(_localctx, RULE_expr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(422);
			switch (_input.LA(1)) {
			case NOT:
				{
				setState(412); ((ExprContext)_localctx).op = match(NOT);
				setState(413); expr(15);
				}
				break;
			case MINUS:
				{
				setState(414); ((ExprContext)_localctx).op = match(MINUS);
				setState(415); expr(14);
				}
				break;
			case WORD:
				{
				setState(416); objRefEx();
				}
				break;
			case LP:
				{
				setState(417); match(LP);
				setState(418); expr(0);
				setState(419); match(RP);
				}
				break;
			case TRUE:
			case FALSE:
			case INT:
			case STRING:
			case FLOAT:
				{
				setState(421); literal();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(465);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(463);
					switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(424);
						if (!(13 >= _localctx._p)) throw new FailedPredicateException(this, "13 >= $_p");
						setState(425); ((ExprContext)_localctx).op = match(MUL);
						setState(426); expr(14);
						}
						break;

					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(427);
						if (!(12 >= _localctx._p)) throw new FailedPredicateException(this, "12 >= $_p");
						setState(428); ((ExprContext)_localctx).op = match(DIV);
						setState(429); expr(13);
						}
						break;

					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(430);
						if (!(11 >= _localctx._p)) throw new FailedPredicateException(this, "11 >= $_p");
						setState(431); ((ExprContext)_localctx).op = match(MOD);
						setState(432); expr(12);
						}
						break;

					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(433);
						if (!(10 >= _localctx._p)) throw new FailedPredicateException(this, "10 >= $_p");
						setState(434); ((ExprContext)_localctx).op = match(PLUS);
						setState(435); expr(11);
						}
						break;

					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(436);
						if (!(9 >= _localctx._p)) throw new FailedPredicateException(this, "9 >= $_p");
						setState(437); ((ExprContext)_localctx).op = match(MINUS);
						setState(438); expr(10);
						}
						break;

					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(439);
						if (!(8 >= _localctx._p)) throw new FailedPredicateException(this, "8 >= $_p");
						setState(440); ((ExprContext)_localctx).op = match(EQUALS);
						setState(441); expr(9);
						}
						break;

					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(442);
						if (!(7 >= _localctx._p)) throw new FailedPredicateException(this, "7 >= $_p");
						setState(443); ((ExprContext)_localctx).op = match(LT);
						setState(444); expr(8);
						}
						break;

					case 8:
						{
						_localctx = new ExprContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(445);
						if (!(6 >= _localctx._p)) throw new FailedPredicateException(this, "6 >= $_p");
						setState(446); ((ExprContext)_localctx).op = match(GT);
						setState(447); expr(7);
						}
						break;

					case 9:
						{
						_localctx = new ExprContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(448);
						if (!(5 >= _localctx._p)) throw new FailedPredicateException(this, "5 >= $_p");
						setState(449); ((ExprContext)_localctx).op = match(LTE);
						setState(450); expr(6);
						}
						break;

					case 10:
						{
						_localctx = new ExprContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(451);
						if (!(4 >= _localctx._p)) throw new FailedPredicateException(this, "4 >= $_p");
						setState(452); ((ExprContext)_localctx).op = match(GTE);
						setState(453); expr(5);
						}
						break;

					case 11:
						{
						_localctx = new ExprContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(454);
						if (!(3 >= _localctx._p)) throw new FailedPredicateException(this, "3 >= $_p");
						setState(455); ((ExprContext)_localctx).op = match(NEQ);
						setState(456); expr(4);
						}
						break;

					case 12:
						{
						_localctx = new ExprContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(457);
						if (!(2 >= _localctx._p)) throw new FailedPredicateException(this, "2 >= $_p");
						setState(458); ((ExprContext)_localctx).op = match(AND);
						setState(459); expr(3);
						}
						break;

					case 13:
						{
						_localctx = new ExprContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(460);
						if (!(1 >= _localctx._p)) throw new FailedPredicateException(this, "1 >= $_p");
						setState(461); ((ExprContext)_localctx).op = match(OR);
						setState(462); expr(2);
						}
						break;
					}
					} 
				}
				setState(467);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(GeneruseParser.TRUE, 0); }
		public TerminalNode FLOAT() { return getToken(GeneruseParser.FLOAT, 0); }
		public TerminalNode INT() { return getToken(GeneruseParser.INT, 0); }
		public TerminalNode STRING() { return getToken(GeneruseParser.STRING, 0); }
		public TerminalNode FALSE() { return getToken(GeneruseParser.FALSE, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).exitLiteral(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(468);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << INT) | (1L << STRING) | (1L << FLOAT))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtContext extends ParserRuleContext {
		public AuxVerbContext auxVerb() {
			return getRuleContext(AuxVerbContext.class,0);
		}
		public TerminalNode BEFORE() { return getToken(GeneruseParser.BEFORE, 0); }
		public ActionIdContext actionId() {
			return getRuleContext(ActionIdContext.class,0);
		}
		public ActionSuffixContext actionSuffix() {
			return getRuleContext(ActionSuffixContext.class,0);
		}
		public TerminalNode ARTICLE(int i) {
			return getToken(GeneruseParser.ARTICLE, i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PREPOSITION() { return getToken(GeneruseParser.PREPOSITION, 0); }
		public ResultIdContext resultId() {
			return getRuleContext(ResultIdContext.class,0);
		}
		public MultiParamSpecContext multiParamSpec() {
			return getRuleContext(MultiParamSpecContext.class,0);
		}
		public PastSpecContext pastSpec() {
			return getRuleContext(PastSpecContext.class,0);
		}
		public TerminalNode GIVING() { return getToken(GeneruseParser.GIVING, 0); }
		public TerminalNode BE() { return getToken(GeneruseParser.BE, 0); }
		public TerminalNode AFTER() { return getToken(GeneruseParser.AFTER, 0); }
		public List<TerminalNode> ARTICLE() { return getTokens(GeneruseParser.ARTICLE); }
		public NoteSpecContext noteSpec() {
			return getRuleContext(NoteSpecContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).exitStmt(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_stmt);
		int _la;
		try {
			setState(502);
			switch ( getInterpreter().adaptivePredict(_input,58,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(470); actionId();
				setState(472);
				_la = _input.LA(1);
				if (_la==PREPOSITION) {
					{
					setState(471); match(PREPOSITION);
					}
				}

				setState(474); match(ARTICLE);
				setState(475); expr(0);
				setState(477);
				switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
				case 1:
					{
					setState(476); multiParamSpec();
					}
					break;
				}
				setState(484);
				_la = _input.LA(1);
				if (_la==GIVING || _la==BE) {
					{
					setState(479);
					_la = _input.LA(1);
					if ( !(_la==GIVING || _la==BE) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(481);
					_la = _input.LA(1);
					if (_la==ARTICLE) {
						{
						setState(480); match(ARTICLE);
						}
					}

					setState(483); resultId();
					}
				}

				setState(487);
				_la = _input.LA(1);
				if (_la==PREPOSITION) {
					{
					setState(486); actionSuffix();
					}
				}

				setState(490);
				_la = _input.LA(1);
				if (_la==LP) {
					{
					setState(489); noteSpec();
					}
				}

				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(493);
				_la = _input.LA(1);
				if (_la==ARTICLE) {
					{
					setState(492); match(ARTICLE);
					}
				}

				setState(495); expr(0);
				setState(496); auxVerb();
				setState(497); actionId();
				setState(500);
				_la = _input.LA(1);
				if (_la==BEFORE || _la==AFTER) {
					{
					setState(498);
					_la = _input.LA(1);
					if ( !(_la==BEFORE || _la==AFTER) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(499); pastSpec();
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ActionIdContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public ActionIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actionId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).enterActionId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).exitActionId(this);
		}
	}

	public final ActionIdContext actionId() throws RecognitionException {
		ActionIdContext _localctx = new ActionIdContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_actionId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(504); id();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ActionSuffixContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode PREPOSITION() { return getToken(GeneruseParser.PREPOSITION, 0); }
		public TerminalNode ARTICLE() { return getToken(GeneruseParser.ARTICLE, 0); }
		public ActionSuffixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actionSuffix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).enterActionSuffix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).exitActionSuffix(this);
		}
	}

	public final ActionSuffixContext actionSuffix() throws RecognitionException {
		ActionSuffixContext _localctx = new ActionSuffixContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_actionSuffix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(506); match(PREPOSITION);
			setState(508);
			_la = _input.LA(1);
			if (_la==ARTICLE) {
				{
				setState(507); match(ARTICLE);
				}
			}

			setState(510); id();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ResultIdContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public ResultIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_resultId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).enterResultId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).exitResultId(this);
		}
	}

	public final ResultIdContext resultId() throws RecognitionException {
		ResultIdContext _localctx = new ResultIdContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_resultId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(512); id();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PastSpecContext extends ParserRuleContext {
		public ObjRefContext objRef() {
			return getRuleContext(ObjRefContext.class,0);
		}
		public TerminalNode PREPOSITION() { return getToken(GeneruseParser.PREPOSITION, 0); }
		public ActionIdContext actionId() {
			return getRuleContext(ActionIdContext.class,0);
		}
		public TerminalNode ARTICLE() { return getToken(GeneruseParser.ARTICLE, 0); }
		public TimeSpecContext timeSpec() {
			return getRuleContext(TimeSpecContext.class,0);
		}
		public PastSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pastSpec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).enterPastSpec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).exitPastSpec(this);
		}
	}

	public final PastSpecContext pastSpec() throws RecognitionException {
		PastSpecContext _localctx = new PastSpecContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_pastSpec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(514); actionId();
			setState(523);
			switch ( getInterpreter().adaptivePredict(_input,62,_ctx) ) {
			case 1:
				{
				setState(515); match(PREPOSITION);
				setState(517);
				_la = _input.LA(1);
				if (_la==ARTICLE) {
					{
					setState(516); match(ARTICLE);
					}
				}

				setState(519); objRef();
				setState(521);
				_la = _input.LA(1);
				if (_la==ARTICLE) {
					{
					setState(520); timeSpec();
					}
				}

				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TimeSpecContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode ARTICLE() { return getToken(GeneruseParser.ARTICLE, 0); }
		public TimeSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_timeSpec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).enterTimeSpec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).exitTimeSpec(this);
		}
	}

	public final TimeSpecContext timeSpec() throws RecognitionException {
		TimeSpecContext _localctx = new TimeSpecContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_timeSpec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(525); match(ARTICLE);
			setState(526); id();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NoteSpecContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode LP() { return getToken(GeneruseParser.LP, 0); }
		public TerminalNode RP() { return getToken(GeneruseParser.RP, 0); }
		public NoteSuffixContext noteSuffix() {
			return getRuleContext(NoteSuffixContext.class,0);
		}
		public NotePrefixContext notePrefix() {
			return getRuleContext(NotePrefixContext.class,0);
		}
		public NoteSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_noteSpec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).enterNoteSpec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).exitNoteSpec(this);
		}
	}

	public final NoteSpecContext noteSpec() throws RecognitionException {
		NoteSpecContext _localctx = new NoteSpecContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_noteSpec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(528); match(LP);
			setState(529); notePrefix();
			setState(530); expr(0);
			setState(532);
			_la = _input.LA(1);
			if (_la==WORD) {
				{
				setState(531); noteSuffix();
				}
			}

			setState(534); match(RP);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NotePrefixContext extends ParserRuleContext {
		public TerminalNode WORD() { return getToken(GeneruseParser.WORD, 0); }
		public NotePrefixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_notePrefix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).enterNotePrefix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).exitNotePrefix(this);
		}
	}

	public final NotePrefixContext notePrefix() throws RecognitionException {
		NotePrefixContext _localctx = new NotePrefixContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_notePrefix);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(536); match(WORD);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NoteSuffixContext extends ParserRuleContext {
		public TerminalNode WORD() { return getToken(GeneruseParser.WORD, 0); }
		public NoteSuffixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_noteSuffix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).enterNoteSuffix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).exitNoteSuffix(this);
		}
	}

	public final NoteSuffixContext noteSuffix() throws RecognitionException {
		NoteSuffixContext _localctx = new NoteSuffixContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_noteSuffix);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(538); match(WORD);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultiParamSpecContext extends ParserRuleContext {
		public List<TerminalNode> AS() { return getTokens(GeneruseParser.AS); }
		public ConjContext conj(int i) {
			return getRuleContext(ConjContext.class,i);
		}
		public List<ConjContext> conj() {
			return getRuleContexts(ConjContext.class);
		}
		public ParamNameContext paramName(int i) {
			return getRuleContext(ParamNameContext.class,i);
		}
		public List<ParamNameContext> paramName() {
			return getRuleContexts(ParamNameContext.class);
		}
		public TerminalNode IS(int i) {
			return getToken(GeneruseParser.IS, i);
		}
		public List<TerminalNode> IS() { return getTokens(GeneruseParser.IS); }
		public TerminalNode ARTICLE(int i) {
			return getToken(GeneruseParser.ARTICLE, i);
		}
		public TerminalNode AS(int i) {
			return getToken(GeneruseParser.AS, i);
		}
		public AutoParamContext autoParam(int i) {
			return getRuleContext(AutoParamContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public TerminalNode PREPOSITION() { return getToken(GeneruseParser.PREPOSITION, 0); }
		public List<AutoParamContext> autoParam() {
			return getRuleContexts(AutoParamContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> ARTICLE() { return getTokens(GeneruseParser.ARTICLE); }
		public MultiParamSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiParamSpec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).enterMultiParamSpec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).exitMultiParamSpec(this);
		}
	}

	public final MultiParamSpecContext multiParamSpec() throws RecognitionException {
		MultiParamSpecContext _localctx = new MultiParamSpecContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_multiParamSpec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(540); match(PREPOSITION);
			setState(556);
			switch ( getInterpreter().adaptivePredict(_input,66,_ctx) ) {
			case 1:
				{
				{
				setState(542);
				_la = _input.LA(1);
				if (_la==ARTICLE) {
					{
					setState(541); match(ARTICLE);
					}
				}

				setState(544); paramName();
				setState(545); match(IS);
				setState(546); expr(0);
				}
				}
				break;

			case 2:
				{
				{
				setState(548); expr(0);
				setState(549); match(AS);
				setState(551);
				_la = _input.LA(1);
				if (_la==ARTICLE) {
					{
					setState(550); match(ARTICLE);
					}
				}

				setState(553); paramName();
				}
				}
				break;

			case 3:
				{
				setState(555); autoParam();
				}
				break;
			}
			setState(578);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND || _la==COMMA) {
				{
				{
				setState(558); conj();
				setState(574);
				switch ( getInterpreter().adaptivePredict(_input,69,_ctx) ) {
				case 1:
					{
					{
					setState(560);
					_la = _input.LA(1);
					if (_la==ARTICLE) {
						{
						setState(559); match(ARTICLE);
						}
					}

					setState(562); paramName();
					setState(563); match(IS);
					setState(564); expr(0);
					}
					}
					break;

				case 2:
					{
					{
					setState(566); expr(0);
					setState(567); match(AS);
					setState(569);
					_la = _input.LA(1);
					if (_la==ARTICLE) {
						{
						setState(568); match(ARTICLE);
						}
					}

					setState(571); paramName();
					}
					}
					break;

				case 3:
					{
					setState(573); autoParam();
					}
					break;
				}
				}
				}
				setState(580);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AutoParamContext extends ParserRuleContext {
		public ObjRefExContext objRefEx() {
			return getRuleContext(ObjRefExContext.class,0);
		}
		public AutoParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_autoParam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).enterAutoParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).exitAutoParam(this);
		}
	}

	public final AutoParamContext autoParam() throws RecognitionException {
		AutoParamContext _localctx = new AutoParamContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_autoParam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(581); objRefEx();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamNameContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public ParamNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).enterParamName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).exitParamName(this);
		}
	}

	public final ParamNameContext paramName() throws RecognitionException {
		ParamNameContext _localctx = new ParamNameContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_paramName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(583); id();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ObjRefContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public ObjFieldContext objField(int i) {
			return getRuleContext(ObjFieldContext.class,i);
		}
		public TerminalNode MEMBER_SEP(int i) {
			return getToken(GeneruseParser.MEMBER_SEP, i);
		}
		public List<TerminalNode> MEMBER_SEP() { return getTokens(GeneruseParser.MEMBER_SEP); }
		public List<ObjFieldContext> objField() {
			return getRuleContexts(ObjFieldContext.class);
		}
		public ObjRefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objRef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).enterObjRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).exitObjRef(this);
		}
	}

	public final ObjRefContext objRef() throws RecognitionException {
		ObjRefContext _localctx = new ObjRefContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_objRef);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(585); id();
			setState(590);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,71,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(586); match(MEMBER_SEP);
					setState(587); objField();
					}
					} 
				}
				setState(592);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,71,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ObjFieldContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public ObjFieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objField; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).enterObjField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeneruseListener ) ((GeneruseListener)listener).exitObjField(this);
		}
	}

	public final ObjFieldContext objField() throws RecognitionException {
		ObjFieldContext _localctx = new ObjFieldContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_objField);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(593); id();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 33: return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return 13 >= _localctx._p;

		case 1: return 12 >= _localctx._p;

		case 2: return 11 >= _localctx._p;

		case 3: return 10 >= _localctx._p;

		case 4: return 9 >= _localctx._p;

		case 5: return 8 >= _localctx._p;

		case 6: return 7 >= _localctx._p;

		case 7: return 6 >= _localctx._p;

		case 8: return 5 >= _localctx._p;

		case 9: return 4 >= _localctx._p;

		case 10: return 3 >= _localctx._p;

		case 11: return 2 >= _localctx._p;

		case 12: return 1 >= _localctx._p;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3D\u0256\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\3\2\3\2\7\2g\n\2"+
		"\f\2\16\2j\13\2\3\2\3\2\3\2\3\2\3\2\3\2\7\2r\n\2\f\2\16\2u\13\2\3\3\3"+
		"\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\7\4\u0080\n\4\f\4\16\4\u0083\13\4\3\4\3"+
		"\4\3\5\3\5\5\5\u0089\n\5\3\5\3\5\7\5\u008d\n\5\f\5\16\5\u0090\13\5\3\6"+
		"\3\6\3\6\7\6\u0095\n\6\f\6\16\6\u0098\13\6\3\7\3\7\6\7\u009c\n\7\r\7\16"+
		"\7\u009d\3\7\6\7\u00a1\n\7\r\7\16\7\u00a2\3\b\3\b\3\b\6\b\u00a8\n\b\r"+
		"\b\16\b\u00a9\3\t\3\t\6\t\u00ae\n\t\r\t\16\t\u00af\3\n\3\n\6\n\u00b4\n"+
		"\n\r\n\16\n\u00b5\3\13\3\13\3\13\3\13\3\13\6\13\u00bd\n\13\r\13\16\13"+
		"\u00be\5\13\u00c1\n\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\5\f\u00ca\n\f\3\f"+
		"\3\f\6\f\u00ce\n\f\r\f\16\f\u00cf\5\f\u00d2\n\f\3\f\3\f\3\r\3\r\3\r\3"+
		"\r\3\r\6\r\u00db\n\r\r\r\16\r\u00dc\5\r\u00df\n\r\3\r\3\r\3\16\3\16\3"+
		"\16\3\16\5\16\u00e7\n\16\3\16\5\16\u00ea\n\16\3\16\3\16\6\16\u00ee\n\16"+
		"\r\16\16\16\u00ef\5\16\u00f2\n\16\3\16\3\16\3\17\3\17\3\17\3\17\5\17\u00fa"+
		"\n\17\3\17\3\17\6\17\u00fe\n\17\r\17\16\17\u00ff\5\17\u0102\n\17\3\17"+
		"\3\17\3\20\3\20\3\20\3\20\7\20\u010a\n\20\f\20\16\20\u010d\13\20\3\20"+
		"\3\20\3\21\3\21\3\21\3\22\3\22\5\22\u0116\n\22\3\22\3\22\3\22\5\22\u011b"+
		"\n\22\3\22\3\22\7\22\u011f\n\22\f\22\16\22\u0122\13\22\3\23\6\23\u0125"+
		"\n\23\r\23\16\23\u0126\3\24\3\24\5\24\u012b\n\24\3\24\3\24\5\24\u012f"+
		"\n\24\3\24\3\24\5\24\u0133\n\24\5\24\u0135\n\24\3\25\6\25\u0138\n\25\r"+
		"\25\16\25\u0139\3\26\6\26\u013d\n\26\r\26\16\26\u013e\3\27\3\27\3\27\7"+
		"\27\u0144\n\27\f\27\16\27\u0147\13\27\3\27\3\27\3\27\3\27\3\27\3\27\3"+
		"\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3"+
		"\32\3\33\3\33\3\33\3\33\3\34\3\34\3\34\5\34\u0165\n\34\3\34\3\34\3\34"+
		"\7\34\u016a\n\34\f\34\16\34\u016d\13\34\3\34\5\34\u0170\n\34\3\34\3\34"+
		"\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\5\36\u017d\n\36\3\36\3\36"+
		"\3\37\3\37\3\37\5\37\u0184\n\37\3 \3 \3 \5 \u0189\n \3 \3 \3!\3!\3!\7"+
		"!\u0190\n!\f!\16!\u0193\13!\3!\3!\3!\5!\u0198\n!\3\"\3\"\5\"\u019c\n\""+
		"\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\5#\u01a9\n#\3#\3#\3#\3#\3#\3#\3#\3#"+
		"\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#"+
		"\3#\3#\3#\3#\3#\3#\3#\3#\7#\u01d2\n#\f#\16#\u01d5\13#\3$\3$\3%\3%\5%\u01db"+
		"\n%\3%\3%\3%\5%\u01e0\n%\3%\3%\5%\u01e4\n%\3%\5%\u01e7\n%\3%\5%\u01ea"+
		"\n%\3%\5%\u01ed\n%\3%\5%\u01f0\n%\3%\3%\3%\3%\3%\5%\u01f7\n%\5%\u01f9"+
		"\n%\3&\3&\3\'\3\'\5\'\u01ff\n\'\3\'\3\'\3(\3(\3)\3)\3)\5)\u0208\n)\3)"+
		"\3)\5)\u020c\n)\5)\u020e\n)\3*\3*\3*\3+\3+\3+\3+\5+\u0217\n+\3+\3+\3,"+
		"\3,\3-\3-\3.\3.\5.\u0221\n.\3.\3.\3.\3.\3.\3.\3.\5.\u022a\n.\3.\3.\3."+
		"\5.\u022f\n.\3.\3.\5.\u0233\n.\3.\3.\3.\3.\3.\3.\3.\5.\u023c\n.\3.\3."+
		"\3.\5.\u0241\n.\7.\u0243\n.\f.\16.\u0246\13.\3/\3/\3\60\3\60\3\61\3\61"+
		"\3\61\7\61\u024f\n\61\f\61\16\61\u0252\13\61\3\62\3\62\3\62\2\63\2\4\6"+
		"\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRT"+
		"VXZ\\^`b\2\7\3\2\16\17\4\2\34\34..\3\2?@\4\2\24\25)+\4\2\f\f\20\20\u0282"+
		"\2d\3\2\2\2\4v\3\2\2\2\6{\3\2\2\2\b\u0086\3\2\2\2\n\u0091\3\2\2\2\f\u0099"+
		"\3\2\2\2\16\u00a4\3\2\2\2\20\u00ab\3\2\2\2\22\u00b1\3\2\2\2\24\u00b7\3"+
		"\2\2\2\26\u00c4\3\2\2\2\30\u00d5\3\2\2\2\32\u00e2\3\2\2\2\34\u00f5\3\2"+
		"\2\2\36\u0105\3\2\2\2 \u0110\3\2\2\2\"\u0113\3\2\2\2$\u0124\3\2\2\2&\u0134"+
		"\3\2\2\2(\u0137\3\2\2\2*\u013c\3\2\2\2,\u0140\3\2\2\2.\u014e\3\2\2\2\60"+
		"\u0155\3\2\2\2\62\u0157\3\2\2\2\64\u015d\3\2\2\2\66\u0161\3\2\2\28\u0173"+
		"\3\2\2\2:\u0178\3\2\2\2<\u0183\3\2\2\2>\u0185\3\2\2\2@\u0197\3\2\2\2B"+
		"\u0199\3\2\2\2D\u01a8\3\2\2\2F\u01d6\3\2\2\2H\u01f8\3\2\2\2J\u01fa\3\2"+
		"\2\2L\u01fc\3\2\2\2N\u0202\3\2\2\2P\u0204\3\2\2\2R\u020f\3\2\2\2T\u0212"+
		"\3\2\2\2V\u021a\3\2\2\2X\u021c\3\2\2\2Z\u021e\3\2\2\2\\\u0247\3\2\2\2"+
		"^\u0249\3\2\2\2`\u024b\3\2\2\2b\u0253\3\2\2\2dh\5\4\3\2eg\5\6\4\2fe\3"+
		"\2\2\2gj\3\2\2\2hf\3\2\2\2hi\3\2\2\2is\3\2\2\2jh\3\2\2\2kr\5\b\5\2lr\5"+
		"\n\6\2mr\5\f\7\2nr\5\16\b\2or\5\20\t\2pr\5\22\n\2qk\3\2\2\2ql\3\2\2\2"+
		"qm\3\2\2\2qn\3\2\2\2qo\3\2\2\2qp\3\2\2\2ru\3\2\2\2sq\3\2\2\2st\3\2\2\2"+
		"t\3\3\2\2\2us\3\2\2\2vw\7\4\2\2wx\79\2\2xy\5(\25\2yz\7\5\2\2z\5\3\2\2"+
		"\2{|\7\4\2\2|}\7\67\2\2}\u0081\5(\25\2~\u0080\5\64\33\2\177~\3\2\2\2\u0080"+
		"\u0083\3\2\2\2\u0081\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0084\3\2\2"+
		"\2\u0083\u0081\3\2\2\2\u0084\u0085\7\5\2\2\u0085\7\3\2\2\2\u0086\u0088"+
		"\5\24\13\2\u0087\u0089\58\35\2\u0088\u0087\3\2\2\2\u0088\u0089\3\2\2\2"+
		"\u0089\u008a\3\2\2\2\u008a\u008e\5\66\34\2\u008b\u008d\5<\37\2\u008c\u008b"+
		"\3\2\2\2\u008d\u0090\3\2\2\2\u008e\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f"+
		"\t\3\2\2\2\u0090\u008e\3\2\2\2\u0091\u0092\5\26\f\2\u0092\u0096\5\66\34"+
		"\2\u0093\u0095\5<\37\2\u0094\u0093\3\2\2\2\u0095\u0098\3\2\2\2\u0096\u0094"+
		"\3\2\2\2\u0096\u0097\3\2\2\2\u0097\13\3\2\2\2\u0098\u0096\3\2\2\2\u0099"+
		"\u009b\5\30\r\2\u009a\u009c\5.\30\2\u009b\u009a\3\2\2\2\u009c\u009d\3"+
		"\2\2\2\u009d\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u00a0\3\2\2\2\u009f"+
		"\u00a1\5@!\2\u00a0\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a0\3\2\2"+
		"\2\u00a2\u00a3\3\2\2\2\u00a3\r\3\2\2\2\u00a4\u00a5\5\32\16\2\u00a5\u00a7"+
		"\5,\27\2\u00a6\u00a8\5@!\2\u00a7\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9"+
		"\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\17\3\2\2\2\u00ab\u00ad\5\34\17"+
		"\2\u00ac\u00ae\5@!\2\u00ad\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00ad"+
		"\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\21\3\2\2\2\u00b1\u00b3\5\36\20\2\u00b2"+
		"\u00b4\5@!\2\u00b3\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b3\3\2\2"+
		"\2\u00b5\u00b6\3\2\2\2\u00b6\23\3\2\2\2\u00b7\u00b8\7\4\2\2\u00b8\u00b9"+
		"\7\62\2\2\u00b9\u00c0\5(\25\2\u00ba\u00bc\7\r\2\2\u00bb\u00bd\5\64\33"+
		"\2\u00bc\u00bb\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00bc\3\2\2\2\u00be\u00bf"+
		"\3\2\2\2\u00bf\u00c1\3\2\2\2\u00c0\u00ba\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1"+
		"\u00c2\3\2\2\2\u00c2\u00c3\7\5\2\2\u00c3\25\3\2\2\2\u00c4\u00c5\7\4\2"+
		"\2\u00c5\u00c6\7\62\2\2\u00c6\u00c9\5(\25\2\u00c7\u00ca\7\32\2\2\u00c8"+
		"\u00ca\5\"\22\2\u00c9\u00c7\3\2\2\2\u00c9\u00c8\3\2\2\2\u00ca\u00d1\3"+
		"\2\2\2\u00cb\u00cd\7\r\2\2\u00cc\u00ce\5\64\33\2\u00cd\u00cc\3\2\2\2\u00ce"+
		"\u00cf\3\2\2\2\u00cf\u00cd\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d2\3\2"+
		"\2\2\u00d1\u00cb\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3"+
		"\u00d4\7\5\2\2\u00d4\27\3\2\2\2\u00d5\u00d6\7\4\2\2\u00d6\u00d7\7\63\2"+
		"\2\u00d7\u00de\5 \21\2\u00d8\u00da\7\r\2\2\u00d9\u00db\5\64\33\2\u00da"+
		"\u00d9\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00da\3\2\2\2\u00dc\u00dd\3\2"+
		"\2\2\u00dd\u00df\3\2\2\2\u00de\u00d8\3\2\2\2\u00de\u00df\3\2\2\2\u00df"+
		"\u00e0\3\2\2\2\u00e0\u00e1\7\5\2\2\u00e1\31\3\2\2\2\u00e2\u00e3\7\4\2"+
		"\2\u00e3\u00e4\7\64\2\2\u00e4\u00e6\5(\25\2\u00e5\u00e7\5L\'\2\u00e6\u00e5"+
		"\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e9\3\2\2\2\u00e8\u00ea\5\"\22\2"+
		"\u00e9\u00e8\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00f1\3\2\2\2\u00eb\u00ed"+
		"\7\r\2\2\u00ec\u00ee\5\64\33\2\u00ed\u00ec\3\2\2\2\u00ee\u00ef\3\2\2\2"+
		"\u00ef\u00ed\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00f2\3\2\2\2\u00f1\u00eb"+
		"\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00f4\7\5\2\2\u00f4"+
		"\33\3\2\2\2\u00f5\u00f6\7\4\2\2\u00f6\u00f7\7\66\2\2\u00f7\u00f9\5(\25"+
		"\2\u00f8\u00fa\5\"\22\2\u00f9\u00f8\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa"+
		"\u0101\3\2\2\2\u00fb\u00fd\7\r\2\2\u00fc\u00fe\5\64\33\2\u00fd\u00fc\3"+
		"\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\u00fd\3\2\2\2\u00ff\u0100\3\2\2\2\u0100"+
		"\u0102\3\2\2\2\u0101\u00fb\3\2\2\2\u0101\u0102\3\2\2\2\u0102\u0103\3\2"+
		"\2\2\u0103\u0104\7\5\2\2\u0104\35\3\2\2\2\u0105\u0106\7\4\2\2\u0106\u0107"+
		"\7<\2\2\u0107\u010b\5`\61\2\u0108\u010a\5\64\33\2\u0109\u0108\3\2\2\2"+
		"\u010a\u010d\3\2\2\2\u010b\u0109\3\2\2\2\u010b\u010c\3\2\2\2\u010c\u010e"+
		"\3\2\2\2\u010d\u010b\3\2\2\2\u010e\u010f\7\5\2\2\u010f\37\3\2\2\2\u0110"+
		"\u0111\t\2\2\2\u0111\u0112\5(\25\2\u0112!\3\2\2\2\u0113\u0115\7(\2\2\u0114"+
		"\u0116\7\'\2\2\u0115\u0114\3\2\2\2\u0115\u0116\3\2\2\2\u0116\u0117\3\2"+
		"\2\2\u0117\u0120\5(\25\2\u0118\u011a\5$\23\2\u0119\u011b\7\'\2\2\u011a"+
		"\u0119\3\2\2\2\u011a\u011b\3\2\2\2\u011b\u011c\3\2\2\2\u011c\u011d\5("+
		"\25\2\u011d\u011f\3\2\2\2\u011e\u0118\3\2\2\2\u011f\u0122\3\2\2\2\u0120"+
		"\u011e\3\2\2\2\u0120\u0121\3\2\2\2\u0121#\3\2\2\2\u0122\u0120\3\2\2\2"+
		"\u0123\u0125\t\3\2\2\u0124\u0123\3\2\2\2\u0125\u0126\3\2\2\2\u0126\u0124"+
		"\3\2\2\2\u0126\u0127\3\2\2\2\u0127%\3\2\2\2\u0128\u012a\7$\2\2\u0129\u012b"+
		"\7\36\2\2\u012a\u0129\3\2\2\2\u012a\u012b\3\2\2\2\u012b\u0135\3\2\2\2"+
		"\u012c\u012e\7%\2\2\u012d\u012f\7\36\2\2\u012e\u012d\3\2\2\2\u012e\u012f"+
		"\3\2\2\2\u012f\u0135\3\2\2\2\u0130\u0132\7&\2\2\u0131\u0133\7\20\2\2\u0132"+
		"\u0131\3\2\2\2\u0132\u0133\3\2\2\2\u0133\u0135\3\2\2\2\u0134\u0128\3\2"+
		"\2\2\u0134\u012c\3\2\2\2\u0134\u0130\3\2\2\2\u0135\'\3\2\2\2\u0136\u0138"+
		"\7,\2\2\u0137\u0136\3\2\2\2\u0138\u0139\3\2\2\2\u0139\u0137\3\2\2\2\u0139"+
		"\u013a\3\2\2\2\u013a)\3\2\2\2\u013b\u013d\7B\2\2\u013c\u013b\3\2\2\2\u013d"+
		"\u013e\3\2\2\2\u013e\u013c\3\2\2\2\u013e\u013f\3\2\2\2\u013f+\3\2\2\2"+
		"\u0140\u0141\7\4\2\2\u0141\u0145\7\65\2\2\u0142\u0144\5\62\32\2\u0143"+
		"\u0142\3\2\2\2\u0144\u0147\3\2\2\2\u0145\u0143\3\2\2\2\u0145\u0146\3\2"+
		"\2\2\u0146\u0148\3\2\2\2\u0147\u0145\3\2\2\2\u0148\u0149\7\6\2\2\u0149"+
		"\u014a\7\21\2\2\u014a\u014b\5(\25\2\u014b\u014c\7\7\2\2\u014c\u014d\7"+
		"\5\2\2\u014d-\3\2\2\2\u014e\u014f\7\4\2\2\u014f\u0150\t\4\2\2\u0150\u0151"+
		"\5P)\2\u0151\u0152\7(\2\2\u0152\u0153\5\60\31\2\u0153\u0154\7\5\2\2\u0154"+
		"/\3\2\2\2\u0155\u0156\5(\25\2\u0156\61\3\2\2\2\u0157\u0158\5(\25\2\u0158"+
		"\u0159\7\22\2\2\u0159\u015a\7\6\2\2\u015a\u015b\5`\61\2\u015b\u015c\7"+
		"\7\2\2\u015c\63\3\2\2\2\u015d\u015e\5(\25\2\u015e\u015f\7\22\2\2\u015f"+
		"\u0160\7*\2\2\u0160\65\3\2\2\2\u0161\u0162\7\4\2\2\u0162\u0164\7>\2\2"+
		"\u0163\u0165\7A\2\2\u0164\u0163\3\2\2\2\u0164\u0165\3\2\2\2\u0165\u0166"+
		"\3\2\2\2\u0166\u016b\5*\26\2\u0167\u0168\7A\2\2\u0168\u016a\5*\26\2\u0169"+
		"\u0167\3\2\2\2\u016a\u016d\3\2\2\2\u016b\u0169\3\2\2\2\u016b\u016c\3\2"+
		"\2\2\u016c\u016f\3\2\2\2\u016d\u016b\3\2\2\2\u016e\u0170\7A\2\2\u016f"+
		"\u016e\3\2\2\2\u016f\u0170\3\2\2\2\u0170\u0171\3\2\2\2\u0171\u0172\7D"+
		"\2\2\u0172\67\3\2\2\2\u0173\u0174\7\4\2\2\u0174\u0175\7=\2\2\u0175\u0176"+
		"\5H%\2\u0176\u0177\7\5\2\2\u01779\3\2\2\2\u0178\u0179\7\4\2\2\u0179\u017a"+
		"\7;\2\2\u017a\u017c\5(\25\2\u017b\u017d\5Z.\2\u017c\u017b\3\2\2\2\u017c"+
		"\u017d\3\2\2\2\u017d\u017e\3\2\2\2\u017e\u017f\7\5\2\2\u017f;\3\2\2\2"+
		"\u0180\u0184\5@!\2\u0181\u0184\5:\36\2\u0182\u0184\5> \2\u0183\u0180\3"+
		"\2\2\2\u0183\u0181\3\2\2\2\u0183\u0182\3\2\2\2\u0184=\3\2\2\2\u0185\u0186"+
		"\7\4\2\2\u0186\u0188\7:\2\2\u0187\u0189\5H%\2\u0188\u0187\3\2\2\2\u0188"+
		"\u0189\3\2\2\2\u0189\u018a\3\2\2\2\u018a\u018b\7\5\2\2\u018b?\3\2\2\2"+
		"\u018c\u0191\5H%\2\u018d\u018e\7\23\2\2\u018e\u0190\5H%\2\u018f\u018d"+
		"\3\2\2\2\u0190\u0193\3\2\2\2\u0191\u018f\3\2\2\2\u0191\u0192\3\2\2\2\u0192"+
		"\u0194\3\2\2\2\u0193\u0191\3\2\2\2\u0194\u0195\7\n\2\2\u0195\u0198\3\2"+
		"\2\2\u0196\u0198\7\n\2\2\u0197\u018c\3\2\2\2\u0197\u0196\3\2\2\2\u0198"+
		"A\3\2\2\2\u0199\u019b\5`\61\2\u019a\u019c\5 \21\2\u019b\u019a\3\2\2\2"+
		"\u019b\u019c\3\2\2\2\u019cC\3\2\2\2\u019d\u019e\b#\1\2\u019e\u019f\7\36"+
		"\2\2\u019f\u01a9\5D#\2\u01a0\u01a1\7\32\2\2\u01a1\u01a9\5D#\2\u01a2\u01a9"+
		"\5B\"\2\u01a3\u01a4\7\6\2\2\u01a4\u01a5\5D#\2\u01a5\u01a6\7\7\2\2\u01a6"+
		"\u01a9\3\2\2\2\u01a7\u01a9\5F$\2\u01a8\u019d\3\2\2\2\u01a8\u01a0\3\2\2"+
		"\2\u01a8\u01a2\3\2\2\2\u01a8\u01a3\3\2\2\2\u01a8\u01a7\3\2\2\2\u01a9\u01d3"+
		"\3\2\2\2\u01aa\u01ab\6#\2\3\u01ab\u01ac\7\27\2\2\u01ac\u01d2\5D#\2\u01ad"+
		"\u01ae\6#\3\3\u01ae\u01af\7\26\2\2\u01af\u01d2\5D#\2\u01b0\u01b1\6#\4"+
		"\3\u01b1\u01b2\7\30\2\2\u01b2\u01d2\5D#\2\u01b3\u01b4\6#\5\3\u01b4\u01b5"+
		"\7\31\2\2\u01b5\u01d2\5D#\2\u01b6\u01b7\6#\6\3\u01b7\u01b8\7\32\2\2\u01b8"+
		"\u01d2\5D#\2\u01b9\u01ba\6#\7\3\u01ba\u01bb\7\33\2\2\u01bb\u01d2\5D#\2"+
		"\u01bc\u01bd\6#\b\3\u01bd\u01be\7 \2\2\u01be\u01d2\5D#\2\u01bf\u01c0\6"+
		"#\t\3\u01c0\u01c1\7\37\2\2\u01c1\u01d2\5D#\2\u01c2\u01c3\6#\n\3\u01c3"+
		"\u01c4\7\"\2\2\u01c4\u01d2\5D#\2\u01c5\u01c6\6#\13\3\u01c6\u01c7\7!\2"+
		"\2\u01c7\u01d2\5D#\2\u01c8\u01c9\6#\f\3\u01c9\u01ca\7#\2\2\u01ca\u01d2"+
		"\5D#\2\u01cb\u01cc\6#\r\3\u01cc\u01cd\7\34\2\2\u01cd\u01d2\5D#\2\u01ce"+
		"\u01cf\6#\16\3\u01cf\u01d0\7\35\2\2\u01d0\u01d2\5D#\2\u01d1\u01aa\3\2"+
		"\2\2\u01d1\u01ad\3\2\2\2\u01d1\u01b0\3\2\2\2\u01d1\u01b3\3\2\2\2\u01d1"+
		"\u01b6\3\2\2\2\u01d1\u01b9\3\2\2\2\u01d1\u01bc\3\2\2\2\u01d1\u01bf\3\2"+
		"\2\2\u01d1\u01c2\3\2\2\2\u01d1\u01c5\3\2\2\2\u01d1\u01c8\3\2\2\2\u01d1"+
		"\u01cb\3\2\2\2\u01d1\u01ce\3\2\2\2\u01d2\u01d5\3\2\2\2\u01d3\u01d1\3\2"+
		"\2\2\u01d3\u01d4\3\2\2\2\u01d4E\3\2\2\2\u01d5\u01d3\3\2\2\2\u01d6\u01d7"+
		"\t\5\2\2\u01d7G\3\2\2\2\u01d8\u01da\5J&\2\u01d9\u01db\7(\2\2\u01da\u01d9"+
		"\3\2\2\2\u01da\u01db\3\2\2\2\u01db\u01dc\3\2\2\2\u01dc\u01dd\7\'\2\2\u01dd"+
		"\u01df\5D#\2\u01de\u01e0\5Z.\2\u01df\u01de\3\2\2\2\u01df\u01e0\3\2\2\2"+
		"\u01e0\u01e6\3\2\2\2\u01e1\u01e3\t\6\2\2\u01e2\u01e4\7\'\2\2\u01e3\u01e2"+
		"\3\2\2\2\u01e3\u01e4\3\2\2\2\u01e4\u01e5\3\2\2\2\u01e5\u01e7\5N(\2\u01e6"+
		"\u01e1\3\2\2\2\u01e6\u01e7\3\2\2\2\u01e7\u01e9\3\2\2\2\u01e8\u01ea\5L"+
		"\'\2\u01e9\u01e8\3\2\2\2\u01e9\u01ea\3\2\2\2\u01ea\u01ec\3\2\2\2\u01eb"+
		"\u01ed\5T+\2\u01ec\u01eb\3\2\2\2\u01ec\u01ed\3\2\2\2\u01ed\u01f9\3\2\2"+
		"\2\u01ee\u01f0\7\'\2\2\u01ef\u01ee\3\2\2\2\u01ef\u01f0\3\2\2\2\u01f0\u01f1"+
		"\3\2\2\2\u01f1\u01f2\5D#\2\u01f2\u01f3\5&\24\2\u01f3\u01f6\5J&\2\u01f4"+
		"\u01f5\t\2\2\2\u01f5\u01f7\5P)\2\u01f6\u01f4\3\2\2\2\u01f6\u01f7\3\2\2"+
		"\2\u01f7\u01f9\3\2\2\2\u01f8\u01d8\3\2\2\2\u01f8\u01ef\3\2\2\2\u01f9I"+
		"\3\2\2\2\u01fa\u01fb\5(\25\2\u01fbK\3\2\2\2\u01fc\u01fe\7(\2\2\u01fd\u01ff"+
		"\7\'\2\2\u01fe\u01fd\3\2\2\2\u01fe\u01ff\3\2\2\2\u01ff\u0200\3\2\2\2\u0200"+
		"\u0201\5(\25\2\u0201M\3\2\2\2\u0202\u0203\5(\25\2\u0203O\3\2\2\2\u0204"+
		"\u020d\5J&\2\u0205\u0207\7(\2\2\u0206\u0208\7\'\2\2\u0207\u0206\3\2\2"+
		"\2\u0207\u0208\3\2\2\2\u0208\u0209\3\2\2\2\u0209\u020b\5`\61\2\u020a\u020c"+
		"\5R*\2\u020b\u020a\3\2\2\2\u020b\u020c\3\2\2\2\u020c\u020e\3\2\2\2\u020d"+
		"\u0205\3\2\2\2\u020d\u020e\3\2\2\2\u020eQ\3\2\2\2\u020f\u0210\7\'\2\2"+
		"\u0210\u0211\5(\25\2\u0211S\3\2\2\2\u0212\u0213\7\6\2\2\u0213\u0214\5"+
		"V,\2\u0214\u0216\5D#\2\u0215\u0217\5X-\2\u0216\u0215\3\2\2\2\u0216\u0217"+
		"\3\2\2\2\u0217\u0218\3\2\2\2\u0218\u0219\7\7\2\2\u0219U\3\2\2\2\u021a"+
		"\u021b\7,\2\2\u021bW\3\2\2\2\u021c\u021d\7,\2\2\u021dY\3\2\2\2\u021e\u022e"+
		"\7(\2\2\u021f\u0221\7\'\2\2\u0220\u021f\3\2\2\2\u0220\u0221\3\2\2\2\u0221"+
		"\u0222\3\2\2\2\u0222\u0223\5^\60\2\u0223\u0224\7$\2\2\u0224\u0225\5D#"+
		"\2\u0225\u022f\3\2\2\2\u0226\u0227\5D#\2\u0227\u0229\7\21\2\2\u0228\u022a"+
		"\7\'\2\2\u0229\u0228\3\2\2\2\u0229\u022a\3\2\2\2\u022a\u022b\3\2\2\2\u022b"+
		"\u022c\5^\60\2\u022c\u022f\3\2\2\2\u022d\u022f\5\\/\2\u022e\u0220\3\2"+
		"\2\2\u022e\u0226\3\2\2\2\u022e\u022d\3\2\2\2\u022f\u0244\3\2\2\2\u0230"+
		"\u0240\5$\23\2\u0231\u0233\7\'\2\2\u0232\u0231\3\2\2\2\u0232\u0233\3\2"+
		"\2\2\u0233\u0234\3\2\2\2\u0234\u0235\5^\60\2\u0235\u0236\7$\2\2\u0236"+
		"\u0237\5D#\2\u0237\u0241\3\2\2\2\u0238\u0239\5D#\2\u0239\u023b\7\21\2"+
		"\2\u023a\u023c\7\'\2\2\u023b\u023a\3\2\2\2\u023b\u023c\3\2\2\2\u023c\u023d"+
		"\3\2\2\2\u023d\u023e\5^\60\2\u023e\u0241\3\2\2\2\u023f\u0241\5\\/\2\u0240"+
		"\u0232\3\2\2\2\u0240\u0238\3\2\2\2\u0240\u023f\3\2\2\2\u0241\u0243\3\2"+
		"\2\2\u0242\u0230\3\2\2\2\u0243\u0246\3\2\2\2\u0244\u0242\3\2\2\2\u0244"+
		"\u0245\3\2\2\2\u0245[\3\2\2\2\u0246\u0244\3\2\2\2\u0247\u0248\5B\"\2\u0248"+
		"]\3\2\2\2\u0249\u024a\5(\25\2\u024a_\3\2\2\2\u024b\u0250\5(\25\2\u024c"+
		"\u024d\7\13\2\2\u024d\u024f\5b\62\2\u024e\u024c\3\2\2\2\u024f\u0252\3"+
		"\2\2\2\u0250\u024e\3\2\2\2\u0250\u0251\3\2\2\2\u0251a\3\2\2\2\u0252\u0250"+
		"\3\2\2\2\u0253\u0254\5(\25\2\u0254c\3\2\2\2Jhqs\u0081\u0088\u008e\u0096"+
		"\u009d\u00a2\u00a9\u00af\u00b5\u00be\u00c0\u00c9\u00cf\u00d1\u00dc\u00de"+
		"\u00e6\u00e9\u00ef\u00f1\u00f9\u00ff\u0101\u010b\u0115\u011a\u0120\u0126"+
		"\u012a\u012e\u0132\u0134\u0139\u013e\u0145\u0164\u016b\u016f\u017c\u0183"+
		"\u0188\u0191\u0197\u019b\u01a8\u01d1\u01d3\u01da\u01df\u01e3\u01e6\u01e9"+
		"\u01ec\u01ef\u01f6\u01f8\u01fe\u0207\u020b\u020d\u0216\u0220\u0229\u022e"+
		"\u0232\u023b\u0240\u0244\u0250";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}