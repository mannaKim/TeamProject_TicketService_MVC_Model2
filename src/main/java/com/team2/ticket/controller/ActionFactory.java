package com.team2.ticket.controller;

import com.team2.ticket.controller.action.Action;
import com.team2.ticket.controller.action.IndexAction;
import com.team2.ticket.controller.action.admin.AdminCheckAction;
import com.team2.ticket.controller.action.admin.AdminMainAction;
import com.team2.ticket.controller.action.admin.EditAdminAction;
import com.team2.ticket.controller.action.admin.goods.AdminGoodsDetailAction;
import com.team2.ticket.controller.action.admin.goods.AdminGoodsInsertAction;
import com.team2.ticket.controller.action.admin.goods.AdminGoodsInsertFormAction;
import com.team2.ticket.controller.action.admin.goods.AdminGoodsListAction;
import com.team2.ticket.controller.action.admin.goods.AdminGoodsOrderListAction;
import com.team2.ticket.controller.action.admin.goods.AdminGoodsOrderModifyAction;
import com.team2.ticket.controller.action.admin.goods.AdminGoodsUpdateAction;
import com.team2.ticket.controller.action.admin.goods.AdminGoodsUpdateFormAction;
import com.team2.ticket.controller.action.admin.goods.ChangeOrderResultAction;
import com.team2.ticket.controller.action.admin.introduce.AdminEventAction;
import com.team2.ticket.controller.action.admin.introduce.AdminEventInsertAction;
import com.team2.ticket.controller.action.admin.introduce.AdminEventViewAction;
import com.team2.ticket.controller.action.admin.introduce.AdminNoticeAction;
import com.team2.ticket.controller.action.admin.introduce.AdminNoticeInsertAction;
import com.team2.ticket.controller.action.admin.introduce.AdminNoticeViewAction;
import com.team2.ticket.controller.action.admin.introduce.DeleteEventAction;
import com.team2.ticket.controller.action.admin.introduce.DeleteNoticeAction;
import com.team2.ticket.controller.action.admin.introduce.EventWriteAction;
import com.team2.ticket.controller.action.admin.introduce.NoticeViewNoCountAction;
import com.team2.ticket.controller.action.admin.introduce.NoticeWriteAction;
import com.team2.ticket.controller.action.admin.introduce.UpdateAction;
import com.team2.ticket.controller.action.admin.introduce.UpdateEventAction;
import com.team2.ticket.controller.action.admin.introduce.UpdateNoticeAction;
import com.team2.ticket.controller.action.admin.introduce.UpdateNoticeFormAction;
import com.team2.ticket.controller.action.admin.introduce.adminNoticeCheckAction;
import com.team2.ticket.controller.action.admin.introduce.adminNoticeCheckpassAction;
import com.team2.ticket.controller.action.admin.qna.AQnaAction;
import com.team2.ticket.controller.action.admin.qna.AQnaJustViewAction;
import com.team2.ticket.controller.action.admin.qna.AQnaViewAction;
import com.team2.ticket.controller.action.admin.ticket.Admin_UpdateFormAction;
import com.team2.ticket.controller.action.admin.ticket.Admin_deleteFormAction;
import com.team2.ticket.controller.action.admin.ticket.Admin_ticketAction;
import com.team2.ticket.controller.action.admin.ticket.Admin_ticketListAction;
import com.team2.ticket.controller.action.admin.ticket.Admin_ticketWriteAction;
import com.team2.ticket.controller.action.admin.ticket.Admin_ticketWriteFormAction;
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
import com.team2.ticket.controller.action.introduce.EventAction;
import com.team2.ticket.controller.action.introduce.EventDetailAction;
import com.team2.ticket.controller.action.introduce.EventDetailNoCountAction;
import com.team2.ticket.controller.action.introduce.EventReplyAction;
import com.team2.ticket.controller.action.introduce.EventReplyWitoutAction;
import com.team2.ticket.controller.action.introduce.IntroduceAction;
import com.team2.ticket.controller.action.introduce.NoticeAction;
import com.team2.ticket.controller.action.introduce.NoticeViewAction;
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
import com.team2.ticket.controller.action.mypage.TicketCartListAction;
import com.team2.ticket.controller.action.mypage.TicketShowMypageAction;
import com.team2.ticket.controller.action.mypage.WithdrawalAction;
import com.team2.ticket.controller.action.mypage.WithdrawalFormAction;
import com.team2.ticket.controller.action.qna.QnaAction;
import com.team2.ticket.controller.action.qna.QnaFnqAction;
import com.team2.ticket.controller.action.qna.QnaJustViewAction;
import com.team2.ticket.controller.action.qna.QnaReAction;
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
		
		// ▶ member 관련 action
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
		
		
		// ▶ mypage 관련 action
		else if(command.equals("mypage")) ac = new MypageAction();
		else if(command.equals("checkPwdForm")) ac = new CheckPwdFormAction();
		else if(command.equals("checkPwd")) ac = new CheckPwdAction();
		else if(command.equals("withdrawalForm")) ac = new WithdrawalFormAction();
		else if(command.equals("withdrawal")) ac = new WithdrawalAction();
		else if(command.equals("modifyMemberForm")) ac = new ModifyMemberFormAction();
		else if(command.equals("modifyMember")) ac = new ModifyMemberAction();
		else if(command.equals("allGoodsOrderList")) ac = new AllGoodsOrderListAction();
		else if(command.equals("goodsOrderDetail")) ac = new GoodsOrderDetailAction();
		else if(command.equals("ticketCartList")) ac = new TicketCartListAction();
		else if(command.equals("ticketShowMypage")) ac = new TicketShowMypageAction();
		
		
		// ▶ goods 관련 action
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
		
		
		// ▶ ticketing 관련 action 
		else if(command.equals("ticketingList")) ac = new TicketingListAction();
		else if(command.equals("ticketingForm")) ac = new TicketingFormAction();
		else if(command.equals("ticketingCart")) ac = new TicketingCartAction();
		else if(command.equals("ticketingCartList")) ac = new TicketingCartListAction();
		else if(command.equals("ticketing")) ac = new TicketingAction();
		// ▷ 공연(티켓) 소개
		else if(command.equals("ticketshow")) ac = new TicketShowAction();
		else if(command.equals("showUpdate")) ac = new ShowUpdateAction();
		else if(command.equals("ticketShowUpdate")) ac = new TicketShowUpdateAction();
		else if(command.equals("showDelete")) ac = new showDeleteAction();
		
		
		// ▶ 전시소개 관련 action
		// ▷ 전시 소개파트
		else if(command.equals("introduce")) ac = new IntroduceAction();
		// ▷ 전시 공지사항
		else if(command.equals("notice")) ac = new NoticeAction();
		else if(command.equals("noticeView")) ac = new NoticeViewAction();
		// ▷ 전시 이벤트
		else if(command.equals("event")) ac = new EventAction();
		else if(command.equals("eventDetail")) ac = new EventDetailAction();
		else if(command.equals("eventReply")) ac = new EventReplyAction();
		else if(command.equals("eventReplyWitout")) ac = new EventReplyWitoutAction();
		else if(command.equals("delRep")) ac = new DelRepAction();
		else if(command.equals("eventDetailNoCount")) ac = new EventDetailNoCountAction();
				
		
		// ▶ qna 관련 action
		else if(command.equals("qna")) ac = new QnaAction(); // qnalist.jsp로 이동
		else if(command.equals("qnaWriteForm")) ac = new QnaWriteFormAction(); // qnawrite.jsp로 이동
		else if(command.equals("qnaWrite")) ac = new QnaWriteAction(); // qnalist.jsp 로 이동
		else if(command.equals("qnaView")) ac = new QnaJustViewAction(); // qnaview.jsp 로 이동
		else if(command.equals("qnaReView")) ac = new QnaViewAction(); // qnaview.jsp 로 이동
		else if(command.equals("qnaUpdate")) ac = new QnaUpdateAction(); // qnalist.jsp 로 이동
		else if(command.equals("qnaReply")) ac = new QnaReplyAction(); // QnaViewAction 으로 이동
		else if(command.equals("qnare")) ac = new QnaReAction(); // QnaViewAction 으로 이동
		else if(command.equals("qnafnq")) ac = new QnaFnqAction(); // QnaViewAction 으로 이동
		
		
		// ▶ review 관련 action -- 시간 남으면 구현합시당
		else if(command.equals("reviewWriteForm")) ac = new ReviewWriteFormAction();
		else if(command.equals("reviewWrite")) ac = new ReviewWriteAction();
		else if(command.equals("review")) ac = new ReviewAction();
		else if(command.equals("reviewView")) ac = new ReviewViewAction();
		
		
		// ▶ 관리자 페이지
		else if(command.equals("adminMain")) ac = new AdminMainAction();
		else if(command.equals("adminCheck")) ac = new AdminCheckAction();
		else if(command.equals("editadmin")) ac = new EditAdminAction();
		// ▷ 관리자 goods 관련 action
		else if(command.equals("adminGoodsList")) ac = new AdminGoodsListAction();
		else if(command.equals("adminGoodsInsertForm")) ac = new AdminGoodsInsertFormAction();
		else if(command.equals("adminGoodsInsert")) ac = new AdminGoodsInsertAction();
		else if(command.equals("adminGoodsDetail")) ac = new AdminGoodsDetailAction();
		else if(command.equals("adminGoodsUpdateForm")) ac = new AdminGoodsUpdateFormAction();
		else if(command.equals("adminGoodsUpdate")) ac = new AdminGoodsUpdateAction();
		else if(command.equals("adminGoodsOrderList")) ac = new AdminGoodsOrderListAction();
		else if(command.equals("adminGoodsOrderModify")) ac = new AdminGoodsOrderModifyAction();
		else if(command.equals("changeOrderResult")) ac = new ChangeOrderResultAction();
		// ▷ 관리자 qna 관련 action
		else if(command.equals("aqna")) ac = new AQnaAction(); // aqnalist.jsp로 이동
		else if(command.equals("aqnaView")) ac = new AQnaJustViewAction(); // aqnaview.jsp 로 이동
		else if(command.equals("aqnaReView")) ac = new AQnaViewAction(); // aqnaview.jsp 로 이동
		// ▷ 관리자 ticket 관련 action
		else if(command.equals("admin_ticketList")) ac = new Admin_ticketListAction();
		else if(command.equals("admin_ticket")) ac = new Admin_ticketAction();
		else if(command.equals("admin_ticketWriteForm")) ac = new Admin_ticketWriteFormAction();
		else if(command.equals("admin_ticketWrite")) ac = new Admin_ticketWriteAction();
		else if(command.equals("admin_UpdateForm")) ac = new Admin_UpdateFormAction();
		else if(command.equals("admin_deleteForm")) ac = new Admin_deleteFormAction();
		// ▷ 관리자 공지사항 관련 action.
		else if(command.equals("adminNotice"))ac = new AdminNoticeAction();
		else if(command.equals("adminNoticeInsert"))ac = new AdminNoticeInsertAction();
		else if(command.equals("noticeWrite"))ac = new NoticeWriteAction();
		else if(command.equals("adminNoticeView"))ac = new AdminNoticeViewAction();	
		else if(command.equals("adminNoticeCheck"))ac = new adminNoticeCheckAction();
		else if(command.equals("adminNoticeCheckpass"))ac = new adminNoticeCheckpassAction();
		else if(command.equals("updateNoticeForm"))ac = new UpdateNoticeFormAction();
		else if(command.equals("updateNotice"))ac = new UpdateNoticeAction();
		else if(command.equals("noticeViewNoCount"))ac = new NoticeViewNoCountAction();
		else if(command.equals("deleteNotice"))ac = new DeleteNoticeAction();	
		// ▷ 관리자 이벤트 관련 action
		else if(command.equals("adminEvent"))ac = new AdminEventAction();
		else if(command.equals("adminEventView"))ac = new AdminEventViewAction();
		else if(command.equals("updateEvent"))ac = new UpdateEventAction();
		else if(command.equals("update"))ac = new UpdateAction();
		else if(command.equals("adminEventInsert"))ac = new AdminEventInsertAction();
		else if(command.equals("eventWrite"))ac = new EventWriteAction();
		else if(command.equals("deleteEvent"))ac = new DeleteEventAction();
		
		return ac;
	}
}
