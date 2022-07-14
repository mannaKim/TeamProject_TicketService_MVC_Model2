package com.team2.ticket.controller;

import com.team2.ticket.controller.action.Action;
import com.team2.ticket.controller.action.IndexAction;
import com.team2.ticket.controller.action.goods.GoodsCartDeleteAction;
import com.team2.ticket.controller.action.goods.GoodsCartInsertAction;
import com.team2.ticket.controller.action.goods.GoodsCartListAction;
import com.team2.ticket.controller.action.goods.GoodsCategoryAction;
import com.team2.ticket.controller.action.goods.GoodsDetailAction;
import com.team2.ticket.controller.action.goods.GoodsMainAction;
import com.team2.ticket.controller.action.goods.GoodsOrderInsertAction;
import com.team2.ticket.controller.action.goods.GoodsOrderInsertListAction;
import com.team2.ticket.controller.action.goods.GoodsOrderListAction;
import com.team2.ticket.controller.action.goods.GoodsSearchAction;
import com.team2.ticket.controller.action.introduce.DelRepAction;
import com.team2.ticket.controller.action.introduce.DeleteNoticeAction;
import com.team2.ticket.controller.action.introduce.EventAction;
import com.team2.ticket.controller.action.introduce.EventDetailAction;
import com.team2.ticket.controller.action.introduce.EventDetailNoCountAction;
import com.team2.ticket.controller.action.introduce.EventReplyAction;
import com.team2.ticket.controller.action.introduce.EventReplyWitoutAction;
import com.team2.ticket.controller.action.introduce.IntroduceAction;
import com.team2.ticket.controller.action.introduce.NoticeAction;
import com.team2.ticket.controller.action.introduce.NoticeCheckAction;
import com.team2.ticket.controller.action.introduce.NoticeCheckpassAction;
import com.team2.ticket.controller.action.introduce.NoticeViewAction;
import com.team2.ticket.controller.action.introduce.NoticeViewNoCountAction;
import com.team2.ticket.controller.action.introduce.UpdateAction;
import com.team2.ticket.controller.action.introduce.UpdateEventAction;
import com.team2.ticket.controller.action.introduce.UpdateNoticeAction;
import com.team2.ticket.controller.action.introduce.UpdateNoticeFormAction;
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
import com.team2.ticket.controller.action.mypage.AllGoodsOrderListAction;
import com.team2.ticket.controller.action.mypage.CheckPwdAction;
import com.team2.ticket.controller.action.mypage.CheckPwdFormAction;
import com.team2.ticket.controller.action.mypage.GoodsOrderDetailAction;
import com.team2.ticket.controller.action.mypage.ModifyMemberAction;
import com.team2.ticket.controller.action.mypage.ModifyMemberFormAction;
import com.team2.ticket.controller.action.mypage.MypageAction;
import com.team2.ticket.controller.action.mypage.WithdrawalAction;
import com.team2.ticket.controller.action.mypage.WithdrawalFormAction;
import com.team2.ticket.controller.action.qna.QnaAction;
import com.team2.ticket.controller.action.qna.QnaJustViewAction;
import com.team2.ticket.controller.action.qna.QnaReplyAction;
import com.team2.ticket.controller.action.qna.QnaUpdateAction;
import com.team2.ticket.controller.action.qna.QnaViewAction;
import com.team2.ticket.controller.action.qna.QnaWriteAction;
import com.team2.ticket.controller.action.qna.QnaWriteFormAction;
import com.team2.ticket.controller.action.review.ReviewAction;
import com.team2.ticket.controller.action.review.ReviewViewAction;
import com.team2.ticket.controller.action.review.ReviewWriteAction;
import com.team2.ticket.controller.action.review.ReviewWriteFormAction;
import com.team2.ticket.controller.action.ticketing.ShowUpdateAction;
import com.team2.ticket.controller.action.ticketing.TicketShowAction;
import com.team2.ticket.controller.action.ticketing.TicketShowUpdateAction;
import com.team2.ticket.controller.action.ticketing.TicketingAction;
import com.team2.ticket.controller.action.ticketing.TicketingCartAction;
import com.team2.ticket.controller.action.ticketing.TicketingCartListAction;
import com.team2.ticket.controller.action.ticketing.TicketingFormAction;
import com.team2.ticket.controller.action.ticketing.TicketingListAction;
import com.team2.ticket.controller.action.ticketing.showDeleteAction;

public class ActionFactory {
	
	//Singleton Pattern
	private ActionFactory() {}
	private static ActionFactory itc = new ActionFactory();
	public static ActionFactory getInstance() {return itc;}
	
	//command 값에 따라 Action 객체 변화
	public Action getAction(String command) {
		Action ac = null;
		
		if(command.equals("index")) ac = new IndexAction();
		
		// ▷ member 관련 action
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
		
		// ▷ mypage 관련 action
		else if(command.equals("mypage")) ac = new MypageAction();
		else if(command.equals("checkPwdForm")) ac = new CheckPwdFormAction();
		else if(command.equals("checkPwd")) ac = new CheckPwdAction();
		else if(command.equals("withdrawalForm")) ac = new WithdrawalFormAction();
		else if(command.equals("withdrawal")) ac = new WithdrawalAction();
		else if(command.equals("modifyMemberForm")) ac = new ModifyMemberFormAction();
		else if(command.equals("modifyMember")) ac = new ModifyMemberAction();
		else if(command.equals("allGoodsOrderList")) ac = new AllGoodsOrderListAction();
		else if(command.equals("goodsOrderDetail")) ac = new GoodsOrderDetailAction();
		
		// ▷ goods 관련 action
		else if(command.equals("goodsMain")) ac = new GoodsMainAction();
		else if(command.equals("goodsSearch")) ac = new GoodsSearchAction();
		else if(command.equals("goodsCategory")) ac = new GoodsCategoryAction();
		else if(command.equals("goodsDetail")) ac = new GoodsDetailAction();
		else if(command.equals("goodsCartInsert")) ac = new GoodsCartInsertAction();
		else if(command.equals("goodsCartList")) ac = new GoodsCartListAction();
		else if(command.equals("goodsCartDelete")) ac = new GoodsCartDeleteAction();
		else if(command.equals("goodsOrderInsertList")) ac = new GoodsOrderInsertListAction();
		else if(command.equals("goodsOrderList")) ac = new GoodsOrderListAction();
		else if(command.equals("goodsOrderInsert")) ac = new GoodsOrderInsertAction(); //즉시구매
		
		
		// ▷ ticketing 관련 action 
		else if(command.equals("ticketingList")) ac = new TicketingListAction();
		else if(command.equals("ticketingForm")) ac = new TicketingFormAction();
		else if(command.equals("ticketingCart")) ac = new TicketingCartAction();
		else if(command.equals("ticketingCartList")) ac = new TicketingCartListAction();
		else if(command.equals("ticketing")) ac = new TicketingAction();
		//공연(티켓) 소개
		else if(command.equals("ticketshow")) ac = new TicketShowAction();
		else if(command.equals("showUpdate")) ac = new ShowUpdateAction();
		else if(command.equals("ticketShowUpdate")) ac = new TicketShowUpdateAction();
		else if(command.equals("showDelete")) ac = new showDeleteAction();
		
		
		// ▷ 전시소개 관련 action
		// 전시 소개파트
		else if(command.equals("introduce")) ac = new IntroduceAction();
		// 전시 공지사항
		else if(command.equals("notice")) ac = new NoticeAction();
		else if(command.equals("noticeView")) ac = new NoticeViewAction();
		else if(command.equals("noticecheck")) ac = new NoticeCheckAction();
		else if(command.equals("noticecheckpass")) ac = new NoticeCheckpassAction();
		else if(command.equals("updateNoticeForm")) ac = new UpdateNoticeFormAction();
		else if(command.equals("updateNotice")) ac = new UpdateNoticeAction();
		else if(command.equals("noticeViewNoCount")) ac = new NoticeViewNoCountAction();
		else if(command.equals("deleteNotice")) ac = new DeleteNoticeAction();
		//전시 이벤트
		else if(command.equals("event")) ac = new EventAction();
		else if(command.equals("eventDetail")) ac = new EventDetailAction();
		else if(command.equals("updateEvent")) ac = new UpdateEventAction();
		else if(command.equals("update")) ac = new UpdateAction();
		else if(command.equals("eventReply")) ac = new EventReplyAction();
		else if(command.equals("eventReplyWitout")) ac = new EventReplyWitoutAction();
		else if(command.equals("delRep")) ac = new DelRepAction();
		else if(command.equals("eventDetailNoCount")) ac = new EventDetailNoCountAction();
				
		// ▷ qna 관련 action
		else if(command.equals("qna")) ac = new QnaAction(); // qnalist.jsp로 이동
		else if(command.equals("qnaWriteForm")) ac = new QnaWriteFormAction(); // qnawrite.jsp로 이동
		else if(command.equals("qnaWrite")) ac = new QnaWriteAction(); // qnalist.jsp 로 이동
		else if(command.equals("qnaView")) ac = new QnaJustViewAction(); // qnaview.jsp 로 이동
		else if(command.equals("qnaReView")) ac = new QnaViewAction(); // qnaview.jsp 로 이동
		else if(command.equals("qnaUpdate")) ac = new QnaUpdateAction(); // qnalist.jsp 로 이동
		else if(command.equals("qnaReply")) ac = new QnaReplyAction(); // QnaViewAction 으로 이동
		
		// ▷ review 관련 action
		else if(command.equals("reviewWriteForm")) ac = new ReviewWriteFormAction();
		else if(command.equals("reviewWrite")) ac = new ReviewWriteAction();
		else if(command.equals("review")) ac = new ReviewAction();
		else if(command.equals("reviewView")) ac = new ReviewViewAction();
		
		return ac;
	}
}
