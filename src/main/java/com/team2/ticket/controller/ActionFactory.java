package com.team2.ticket.controller;

import com.team2.ticket.controller.action.Action;
import com.team2.ticket.controller.action.IndexAction;
import com.team2.ticket.controller.action.goods.GoodsCategoryAction;
import com.team2.ticket.controller.action.goods.GoodsDetailAction;
import com.team2.ticket.controller.action.goods.GoodsMainAction;
import com.team2.ticket.controller.action.member.CompleteJoinAction;
import com.team2.ticket.controller.action.member.FindAddressAction;
import com.team2.ticket.controller.action.member.FindIdAction;
import com.team2.ticket.controller.action.member.FindIdFormAction;
import com.team2.ticket.controller.action.member.FindPwdFormAction;
import com.team2.ticket.controller.action.member.FindPwdStep1Action;
import com.team2.ticket.controller.action.member.FindPwdStep2Action;
import com.team2.ticket.controller.action.member.IdCheckFormAction;
import com.team2.ticket.controller.action.member.JoinAction;
import com.team2.ticket.controller.action.member.JoinFormAction;
import com.team2.ticket.controller.action.member.LoginAction;
import com.team2.ticket.controller.action.member.LoginFormAction;
import com.team2.ticket.controller.action.member.LogoutAction;
import com.team2.ticket.controller.action.member.ResetPwdAction;
import com.team2.ticket.controller.action.member.ShowTermAction;
import com.team2.ticket.controller.action.member.TermsAndConditionsAction;
import com.team2.ticket.controller.action.mypage.CheckPwdAction;
import com.team2.ticket.controller.action.mypage.CheckPwdFormAction;
import com.team2.ticket.controller.action.mypage.ModifyMemberAction;
import com.team2.ticket.controller.action.mypage.ModifyMemberFormAction;
import com.team2.ticket.controller.action.mypage.MypageAction;
import com.team2.ticket.controller.action.mypage.WithdrawalAction;
import com.team2.ticket.controller.action.mypage.WithdrawalFormAction;

public class ActionFactory {
	
	//Singleton Pattern
	private ActionFactory() {}
	private static ActionFactory itc = new ActionFactory();
	public static ActionFactory getInstance() {return itc;}
	
	//command 값에 따라 Action 객체 변화
	public Action getAction(String command) {
		Action ac = null;
		
		if(command.equals("index")) ac = new IndexAction();
		
		else if(command.equals("loginForm")) ac = new LoginFormAction();
		else if(command.equals("login")) ac = new LoginAction();
		else if(command.equals("logout")) ac = new LogoutAction();
		else if(command.equals("termsAndConditions")) ac = new TermsAndConditionsAction();
		else if(command.equals("showTerm")) ac = new ShowTermAction();
		else if(command.equals("joinForm")) ac = new JoinFormAction();
		else if(command.equals("idCheckForm")) ac = new IdCheckFormAction();
		else if(command.equals("findAddress")) ac = new FindAddressAction();
		else if(command.equals("join")) ac = new JoinAction();
		else if(command.equals("completeJoin")) ac = new CompleteJoinAction();
		else if(command.equals("findIdForm")) ac = new FindIdFormAction();
		else if(command.equals("findId")) ac = new FindIdAction();
		else if(command.equals("findPwdForm")) ac = new FindPwdFormAction();
		else if(command.equals("findPwdStep1")) ac = new FindPwdStep1Action();
		else if(command.equals("findPwdStep2")) ac = new FindPwdStep2Action();
		else if(command.equals("resetPwd")) ac = new ResetPwdAction();
		
		else if(command.equals("mypage")) ac = new MypageAction();
		else if(command.equals("checkPwdForm")) ac = new CheckPwdFormAction();
		else if(command.equals("checkPwd")) ac = new CheckPwdAction();
		else if(command.equals("withdrawalForm")) ac = new WithdrawalFormAction();
		else if(command.equals("withdrawal")) ac = new WithdrawalAction();
		else if(command.equals("modifyMemberForm")) ac = new ModifyMemberFormAction();
		else if(command.equals("modifyMember")) ac = new ModifyMemberAction();
		
		else if(command.equals("goodsMain")) ac = new GoodsMainAction();
		else if(command.equals("goodsCategory")) ac = new GoodsCategoryAction();
		else if(command.equals("goodsDetail")) ac = new GoodsDetailAction();
		
		
		return ac;
	}
}
