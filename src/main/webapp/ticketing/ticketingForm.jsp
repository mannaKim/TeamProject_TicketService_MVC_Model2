<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<article>
<h1>Ticketing</h1>
<form method="post" name="formm" action="ticket.do">
<!-- <input type="hidden" name="command" value="ticketingCart"> -->
<h1>${ticket_productVO.name}</h1>
<fieldset>	
	<legend>
		<fmt:formatDate pattern = "yyyy/MM/dd" value="${ticket_productVO.sdate}" type="date" /> ~ 
    	<fmt:formatDate pattern = "yyyy/MM/dd" value="${ticket_productVO.edate}" type="date" />
	</legend>
	<span style="float: left; margin-right:20px;">
		<img  src="ticket_images/${ticket_productVO.image}" 
			width="450" style="border-radius:20px;"/>
	</span>              
	<label>등　급 : </label> 만 ${ticket_productVO.age} 세 이상 <br>
	<label>가　격</label><br>
		<table width="300" height="80" style="background:#949494;">
			<tr>
				<td>
					일　반 : ${ticket_productVO.price1} 원 <br>
					어린이 : ${ticket_productVO.price2} 원 
				</td>
			</tr>
			
		</table><br><br>
	<label>장　소 : </label> ${ticket_productVO.place} <br><br>
	
<!-- 카카오 지도 시작 -->
<div>
<div id="map" style="width:350px;height:350px;"></div>    
	<p>${ticket_productVO.place}</p>
	<script type="text/javascript" 
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=efd85644b092b313e70b0ae83c9f7c58">
	</script>
	<script>
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		mapOption = {
		center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
		level: 3 // 지도의 확대 레벨
    };
	// 지도를 생성합니다    
	var map = new kakao.maps.Map(mapContainer, mapOption);
	// 주소-좌표 변환 객체를 생성합니다
	var geocoder = new kakao.maps.services.Geocoder();
	// 주소로 좌표를 검색합니다
	geocoder.addressSearch('솔샘로 18길', function(result, status) {
    // 정상적으로 검색이 완료됐으면 
		if (status === kakao.maps.services.Status.OK) {
			var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
			// 결과값으로 받은 위치를 마커로 표시합니다
			var marker = new kakao.maps.Marker({
				map: map,
				position: coords
		});
	
		// 인포윈도우로 장소에 대한 설명을 표시합니다
		var infowindow = new kakao.maps.InfoWindow({
			content: '<div style="width:150px;text-align:center;padding:6px 0;">우리회사</div>'
		});
		infowindow.open(map, marker);
	
		// 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
		map.setCenter(coords);
	    } 
	});    
</script>
</div>
</fieldset>
<br>
<!-- 달력 -->
<script type="text/javascript">
	//---------------- calendar --------------------------
	//date객체 획득. 가변
	var today = new Date();
	//today 보조. 고정
	var date = new Date();
	//선택되있던 셀 객체 저장
	var selectedCell;
	//오늘에 해당하는 월
	var realMonth = date.getMonth() + 1;
	var realToDay = date.getDate()
	//선택된 월, 일
	var selectedMonth = null;
	var selectedDate = null;

	// 예약가능 요일 계산해 배열 (일~월, 가능0 불가능1)
	// const possibleDay = possibleDay;

	//달력 제작 (이번달 기준)
	function buildCalendar() {
		row = null;
		cnt = 0;
		sDate = new Date(today.getFullYear(), today.getMonth(), 1);
		eDate = new Date(today.getFullYear(), today.getMonth() + 1, 0);
		//현재 참조중인 월 
		nowMonth = today.getMonth() + 1;
		//이번달이면 0, 다음달이면 1 리턴
		monthEquals = thisMonth(nowMonth, realMonth);
		//달력 객체
		var calendarTable = document.getElementById("calendar");
		//달력의 타이틀 객체 획득
		var calendarTableTitle = document.getElementById("calendarTitle");
		//타이틀 수정
		calendarTableTitle.innerHTML = today.getFullYear() + "년"
				+ (today.getMonth() + 1) + "월";

		//테이블 초기화
		while (calendarTable.rows.length > 2) {
			calendarTable.deleteRow(calendarTable.rows.length - 1);
		}

		//셀 입력을 위해 테이블 개행
		row = calendarTable.insertRow();

		
		//달의 첫 날 전까지 빈 셀 생성
		for (i = 0; i < sDate.getDay(); i++) {
			cell = row.insertCell();
			cnt += 1;
		}

		//요일 입력 (셀 생성)
		for (i = 1; i <= eDate.getDate(); i++) {
			//예약하지 못하는 조건일경우 +1씩 되므로, noCount가 0일 시에만 클릭함수를 적용
			noCount = 0;
			cell = row.insertCell();
		  	
			
			//cell에 id 부여
			cell.setAttribute('id', i);
			cell.innerHTML = i;
			//cell.innerHTML = '<label onclick="prevCalendar()">' + i + '</label>';
			cell.align = "center";

			//셀 생성 후 count 증가
			cnt += 1;

			//cnt % 7 == 1이면 일요일이므로 빨갛게
			if (cnt % 7 == 1) {
				cell.innerHTML = "<font color=red>" + i + "</font>";
			}

			//일주일 입력 완료시 개행
			if (cnt % 7 == 0) {
				//cnt % 7 == 0이면 토요일이므로 파랗게
				cell.innerHTML = "<font color=blue>" + i + "</font>";
				row = calendar.insertRow();
			}
			
			//예약불가일 색상변경 (오늘 이전 또는 30일 이후) 및 사용자가 직접 지정한 경우
			etp = exchangeToPosibleDay(cnt)*1;
			
			if (nowMonth == realMonth && i <= realToDay) {
				noCount +=1;
	        } else if (nowMonth > realMonth && i > realToDay) {
				noCount +=1;
	        }
			
	        
			if (noCount > 0){
				cell.style.backgroundColor = "#E0E0E0";
				cell.innerHTML = "<font color='#C6C6C6' >" + i + "</font>";
			} else { 
				cell.onclick = function(){
					selectedTimeAndTotalPriceInit();
					//선택된 날의 연, 월, 일 계산 (일자의 경우 id속성 참조)
					clickedYear = today.getFullYear();
					clickedMonth = (1 + today.getMonth());
					clickedMonth = clickedMonth >= 10 ? clickedMonth : '0' + clickedMonth;
					clickedDate = this.getAttribute('id');
					clickedDate = clickedDate >= 10 ? clickedDate : '0' + clickedDate;
					
					clickedYMD = clickedYear + "-" + clickedMonth + "-" + clickedDate;
					
					//하단에 예약일시 표시
					inputField = document.getElementById("selectedDate");
					inputField.value = clickedYMD;
					//선택된 월, 일 변수 저장
					selectedMonth = today.getMonth() + 1;
					selectedDate = this.getAttribute('id');
					
					//선택된 셀 색 변화
					if(selectedCell != null){
						selectedCell.bgColor = "#FFFFFF";
					}
					selectedCell = this;
					this.bgColor = "#fbedaa";
					
				}
			}

		}

		//달의 마지막날 뒤 행의 빈 공간을 셀로 채우기
		if (cnt % 7 != 0) {
			for (i = 0; i < 7 - (cnt % 7); i++) {
				cell = row.insertCell();
			}
		}
	}
	
	//사용자가 입력한 예약불가능 일자와 대조하기 위해 0~7의 환형 계산구조
	function exchangeToPosibleDay(num) {
		result = num % 7;
		result -= 1;
		if (result == -1) {
			result = 6;
		}
		return result;
	}
	
	//이번달이면 0 리턴, 다음달이면 1 리턴
	function thisMonth(todayMonth, dateMonth) {
		console
				.log("todayMonth : " + todayMonth + ", dateMonth : "
						+ dateMonth);
		if (todayMonth * 1 == dateMonth * 1) {
			console.log("이번달 이구요")
			return 0;
		}
		console.log("다음달 이구요")
		return 1;
	}
	
	//전달 달력
	function prevCalendar() {
		if (today.getMonth() < realMonth){
			alert("예약은 금일기준 다음날부터 30일 이후까지만 가능합니다.");	
			return false;
		}
		today = new Date(today.getFullYear(), today.getMonth() - 1, today
				.getDate());
		buildCalendar();
	}
	
	//다음달 달력
	function nextCalendar() {
		if(today.getMonth()+1 == (realMonth + 1)){
			alert("예약은 금일기준 다음날부터 30일 이후까지만 가능합니다.");
			return false;
		}
		today = new Date(today.getFullYear(), today.getMonth() + 1, today
				.getDate());
		buildCalendar();
	}
	
	//날짜 선택
	function selectedTimeAndTotalPriceInit(){
		resDateForm = document.getElementById("selectedDate");
		resDateForm.value = "";
		
	}
	
</script>
<div>
<div>
<table id="reservation_time">
	<tr>
		<td class="top" align="center" 
			style="color: #505050; font-size:40px; font-weight:700">날짜선택</td>
	</tr>
	<tr>
		<td>
			<table id="calendar" width="250" height="250">
				<tr>
					<td align="center"><label onclick="prevCalendar()"> ◀
					</label></td>
					<td colspan="5" align="center" id="calendarTitle">yyyy년 m월</td>
					<td align="center"><label onclick="nextCalendar()"> ▶
					</label></td>
				</tr>
				<tr>
					<td align="center"><font color="red">일</td>
					<td align="center">월</td>
					<td align="center">화</td>
					<td align="center">수</td>
					<td align="center">목</td>
					<td align="center">금</td>
					<td align="center"><font color="blue">토</td>
				</tr>
			</table>
		</td>
		<td>
			<table id="timeTable">
			</table>
		</td>
	</tr>
	<tr>
		<td class="top" align="center" colspan="2"
			style="color: #505050; font-size:40px; font-weight:700">예약일시</td>
	</tr>
	<tr>
		<td class="content" colspan="2" align="left">
		<input id="selectedDate" style="border:none; width:280px; text-align:center;" 
			name="selectedDate" value="" readonly="readonly" >
		</td>
	</tr>
	<tr>
		<td align="left" colspan="2">
			<input type="button" id="btn_submit" value="예약하기" 
				onclick="return choiceDayCheck('${ticket_productVO.tpseq}')">
			<input type="hidden" name="tpseq" value="${ticket_productVO.tpseq}">
			<div>${message}</div>
		</td>
	<tr>
</table>
</div>
</div>


<script type="text/javascript">buildCalendar();</script>
</form>
</article>

<%@ include file="../footer.jsp" %>