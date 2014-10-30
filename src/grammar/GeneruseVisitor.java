// Generated from E:\generuse-project\generuse\src\grammar\Generuse.g4 by ANTLR 4.1
package com.generuse.parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GeneruseParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GeneruseVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GeneruseParser#autoParamSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAutoParamSpec(@NotNull GeneruseParser.AutoParamSpecContext ctx);

	/**
	 * Visit a parse tree produced by {@link GeneruseParser#stateHeader}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStateHeader(@NotNull GeneruseParser.StateHeaderContext ctx);

	/**
	 * Visit a parse tree produced by {@link GeneruseParser#state}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitState(@NotNull GeneruseParser.StateContext ctx);

	/**
	 * Visit a parse tree produced by {@link GeneruseParser#sentence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentence(@NotNull GeneruseParser.SentenceContext ctx);

	/**
	 * Visit a parse tree produced by {@link GeneruseParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(@NotNull GeneruseParser.ExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link GeneruseParser#resultId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResultId(@NotNull GeneruseParser.ResultIdContext ctx);

	/**
	 * Visit a parse tree produced by {@link GeneruseParser#objectSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectSpec(@NotNull GeneruseParser.ObjectSpecContext ctx);

	/**
	 * Visit a parse tree produced by {@link GeneruseParser#actorSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitActorSpec(@NotNull GeneruseParser.ActorSpecContext ctx);

	/**
	 * Visit a parse tree produced by {@link GeneruseParser#id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(@NotNull GeneruseParser.IdContext ctx);

	/**
	 * Visit a parse tree produced by {@link GeneruseParser#actorId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitActorId(@NotNull GeneruseParser.ActorIdContext ctx);

	/**
	 * Visit a parse tree produced by {@link GeneruseParser#branchSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBranchSpec(@NotNull GeneruseParser.BranchSpecContext ctx);

	/**
	 * Visit a parse tree produced by {@link GeneruseParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommand(@NotNull GeneruseParser.CommandContext ctx);

	/**
	 * Visit a parse tree produced by {@link GeneruseParser#action}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAction(@NotNull GeneruseParser.ActionContext ctx);

	/**
	 * Visit a parse tree produced by {@link GeneruseParser#usecased}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUsecased(@NotNull GeneruseParser.UsecasedContext ctx);

	/**
	 * Visit a parse tree produced by {@link GeneruseParser#preconditionSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreconditionSpec(@NotNull GeneruseParser.PreconditionSpecContext ctx);

	/**
	 * Visit a parse tree produced by {@link GeneruseParser#formulaHeader}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormulaHeader(@NotNull GeneruseParser.FormulaHeaderContext ctx);

	/**
	 * Visit a parse tree produced by {@link GeneruseParser#formalParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParam(@NotNull GeneruseParser.FormalParamContext ctx);

	/**
	 * Visit a parse tree produced by {@link GeneruseParser#doSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoSpec(@NotNull GeneruseParser.DoSpecContext ctx);

	/**
	 * Visit a parse tree produced by {@link GeneruseParser#usecase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUsecase(@NotNull GeneruseParser.UsecaseContext ctx);

	/**
	 * Visit a parse tree produced by {@link GeneruseParser#usecaseHeader}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUsecaseHeader(@NotNull GeneruseParser.UsecaseHeaderContext ctx);

	/**
	 * Visit a parse tree produced by {@link GeneruseParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(@NotNull GeneruseParser.StmtContext ctx);

	/**
	 * Visit a parse tree produced by {@link GeneruseParser#actionHeader}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitActionHeader(@NotNull GeneruseParser.ActionHeaderContext ctx);

	/**
	 * Visit a parse tree produced by {@link GeneruseParser#objRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjRef(@NotNull GeneruseParser.ObjRefContext ctx);

	/**
	 * Visit a parse tree produced by {@link GeneruseParser#gss}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGss(@NotNull GeneruseParser.GssContext ctx);

	/**
	 * Visit a parse tree produced by {@link GeneruseParser#auxVerb}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAuxVerb(@NotNull GeneruseParser.AuxVerbContext ctx);

	/**
	 * Visit a parse tree produced by {@link GeneruseParser#importSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportSpec(@NotNull GeneruseParser.ImportSpecContext ctx);

	/**
	 * Visit a parse tree produced by {@link GeneruseParser#groupSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroupSpec(@NotNull GeneruseParser.GroupSpecContext ctx);

	/**
	 * Visit a parse tree produced by {@link GeneruseParser#contextSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContextSpec(@NotNull GeneruseParser.ContextSpecContext ctx);

	/**
	 * Visit a parse tree produced by {@link GeneruseParser#multiParamSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiParamSpec(@NotNull GeneruseParser.MultiParamSpecContext ctx);

	/**
	 * Visit a parse tree produced by {@link GeneruseParser#usecasedHeader}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUsecasedHeader(@NotNull GeneruseParser.UsecasedHeaderContext ctx);

	/**
	 * Visit a parse tree produced by {@link GeneruseParser#attributeValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributeValue(@NotNull GeneruseParser.AttributeValueContext ctx);

	/**
	 * Visit a parse tree produced by {@link GeneruseParser#needSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNeedSpec(@NotNull GeneruseParser.NeedSpecContext ctx);

	/**
	 * Visit a parse tree produced by {@link GeneruseParser#actionId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitActionId(@NotNull GeneruseParser.ActionIdContext ctx);

	/**
	 * Visit a parse tree produced by {@link GeneruseParser#paramName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamName(@NotNull GeneruseParser.ParamNameContext ctx);

	/**
	 * Visit a parse tree produced by {@link GeneruseParser#objField}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjField(@NotNull GeneruseParser.ObjFieldContext ctx);

	/**
	 * Visit a parse tree produced by {@link GeneruseParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(@NotNull GeneruseParser.LiteralContext ctx);

	/**
	 * Visit a parse tree produced by {@link GeneruseParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormula(@NotNull GeneruseParser.FormulaContext ctx);
}