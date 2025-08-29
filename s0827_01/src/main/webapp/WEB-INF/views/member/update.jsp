<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<link rel="stylesheet" type="text/css" href="/css/style_header.css">
		<link rel="stylesheet" type="text/css" href="/css/style_join02_info_input.css">
		<link rel="stylesheet" type="text/css" href="/css/style_footer.css">
		<title>회원정보수정</title>
		<script>
		
		</script>
	</head>
	<body>
		<header>
			<div id="nav_up">
				<ul>
					<li><a href="#">회원가입</a></li>
					<li><a href="#">로그인</a></li>
					<li><a href="#">고객행복센터</a></li>
					<li><a href="#">배송지역검색</a></li>
					<li><a href="#">기프트카드 등록</a></li>
				</ul>
			</div>	
			<nav>
				<a href="#"></a>
				<ul>
					<li><a href="#">COOKIT소개</a></li>
					<li><a href="#">COOKIT메뉴</a></li>
					<li><a href="#">리뷰</a></li>
					<li><a href="#">이벤트</a></li>
					<li><a href="#">MY쿡킷</a></li>
				</ul>
				<ul>
					<li>
						<a href="#"><span>장바구니</span></a>
					</li>
					<li>
						<a href="#"><span>메뉴찾기</span></a>
					</li>
				</ul>
			</nav>
		</header>
		
		
		
		
		
		<section>
			<form action="/member/update" name="agree" method="post" >
				<div id="subBanner"></div>
				<div id="locationN">
					<ul>
						<li>HOME</li>
						<li>회원수정</li>
						<li>회원정보수정</li>
					</ul>
				</div>
				
				<div id="sub_top_area">
					<h3>회원정보수정</h3>
				</div>
				
				
				<h4>
					필수 정보 입력 
					<span>(* 항목은 필수 항목입니다.)</span>
				</h4>
				<fieldset class="fieldset_class">
					<dl id="join_name_dl">
						<dt>
							<div></div>
							<label for="name">이름</label>
						</dt>
						<dd>
							<input type="text" id="name" name="name" value="${member.name}" readonly required/>
						</dd>
					</dl>
					<dl id="join_id_dl">
						<dt>
							<div></div>
							<label for="id">아이디</label>
						</dt>
						<dd>
							<input type="text" id="id" name="id" value="${member.id}" minlength="3" maxlength="16" readonly required/>
						</dd>
					</dl>
					<dl id="join_pw1_dl">
						<dt>
							<div></div>
							<label for="pw1">비밀번호</label>
						</dt>
						<dd>
							<input type="password" id="pw1" name="pw" minlength="3" required />
							<span>영문, 숫자, 특수문자 중 2종류 조합 시 10자리 이상 입력</span>
							<span>영문, 숫자, 특수문자 모두 조합 시 8자리 이상 입력</span>
						</dd>
					</dl>
					<dl id="join_pw2_dl">
						<dt>
							<div></div>
							<label for="pw2">비밀번호 확인</label>
						</dt>
						<dd>
							<input type="password" onkeyup="pwCheck()" id="pw2" name="pw2" minlength="3" required />
							<span id="pwCheckText">비밀번호를 다시 한번 입력해 주세요.</span>
						</dd>
					</dl>
					<script>
					  function pwCheck(){
						  console.log("버튼");
						  if($("#pw1").val() == $("#pw2").val()){
							  $("#pwCheckText").css({"color":"blue","font-weight":"bold"});
							  $("#pwCheckText").text("비밀번호가 동일합니다.");
						  }else{
							  $("#pwCheckText").css({"color":"red","font-weight":"bold"});
							  $("#pwCheckText").text("비밀번호가 다릅니다. 다시 입력해 주세요.");
						  }
					  }
					</script>
					<dl id="join_mail_dl">
						<dt>
							<div></div>
							<label for="mail_id">이메일</label>
						</dt>
						<dd>
							<input type="text" id="mail_id" name="email1"  />
							<span>@</span>
							<input type="text" id="main_tail" name="email2"  />
							<select>
								<option selected>직접입력</option>
								<option>지메일</option>
								<option>네이버</option>
								<option>네이트</option>
								<option>핫메일</option>
								<option>파란</option>
								<option>엠팔</option>
								<option>야후</option>
								<option>드림위즈</option>
								<option>한메일(다음)</option>
							</select>
						</dd>
					</dl>
					
					<dl id="join_address_dl">
						<dt> 
							<div></div>
							<label for="">주소</label>
						</dt>
						<dd>
							<input type="text" id="f_postal" name="zipcode1"  />
							<span>-</span>
							<input type="text" id="l_postal" name="zipcode2"  />
							<input type="button" value="우편번호"/>
							<input type="text" id="address1" name="address1"  />
							<input type="text" id="address2" name="address2"  />
						</dd>
						
					</dl>
					
					<dl id="join_tell_dl">
						<dt>
							<div></div>
							<label for="f_tell">휴대전화</label>
						</dt>
						<dd>
							<input type="text" id="f_tell" name="phone1" value="${fn:split(member.phone,'-')[0]}" maxlength="3" required />
							<span> - </span>
							<input type="text" id="m_tell" name="phone2" value="${fn:split(member.phone,'-')[1]}" maxlength="4" required />
							<span> - </span>
							<input type="text" id="l_tell" name="phone3" value="${fn:split(member.phone,'-')[2]}" maxlength="4" required />
						</dd>
					</dl>
					
					<dl id="join_gender_dl">
						<dt>
							<div></div>
							<label for="">성별</label>
						</dt>
						<dd>
							<div>
								<input type="radio" name="gender" id="male" value="남자" 
								<c:if test="${fn:contains(member.gender,'남자')}">checked</c:if>								
								/>
								<label for="male">남성</label>
								<input type="radio" name="gender" id="female" value="여자"
								<c:if test="${fn:contains(member.gender,'여자')}">checked</c:if>	
								/>
								<label for="female">여성</label>
							</div>
						</dd>
					</dl>
					
				</fieldset>

				
				<h4>
					선택 입력 정보 
				</h4>
				<fieldset class="fieldset_class">
					
					
					<dl id="join_interests_dl">
						<dt>
							<label for="">취미</label>
						</dt>
						<dd>
							<ul>
								<li>
									<input type="checkbox" name="hobby" id="game" value="게임" 
									<c:if test="${fn:contains(member.hobby,'게임')}">checked</c:if>	
									/>
									<label for="game">게임</label>
								</li>
								<li>
									<input type="checkbox" name="hobby" id="golf" value="골프" 
									<c:if test="${fn:contains(member.hobby,'골프')}">checked</c:if>	
									/>
									<label for="golf">골프</label>
								</li>
								<li>
									<input type="checkbox" name="hobby" id="swim" value="수영" 
									<c:if test="${fn:contains(member.hobby,'수영')}">checked</c:if>	
									/>
									<label for="swim">수영</label>
								</li>
								<li>
									<input type="checkbox" name="hobby" id="run" value="조깅" 
									<c:if test="${fn:contains(member.hobby,'조깅')}">checked</c:if>	
									/>
									<label for="run">조깅</label>
								</li>
								<li>
									<input type="checkbox" name="hobby" id="book" value="독서" 
									<c:if test="${fn:contains(member.hobby,'독서')}">checked</c:if>	
									/>
									<label for="book">독서</label>
								</li>
								<li>
									<input type="checkbox" name="hobby" id="cook" value="요리" 
									<c:if test="${fn:contains(member.hobby,'요리')}">checked</c:if>	
									/>
									<label for="cook">요리</label>
								</li>
								
							</ul>
						</dd>
					</dl>
				</fieldset>
				<div id="info_input_button">
					<input type="button" onclick="deleteBtn()" value="회원정보삭제" />
					<input type="reset" onclick="location.href='/';" value="취소하기" />
					<input type="submit" value="회원정보수정" />
				</div>
				<script>
				function deleteBtn(){
					if(confirm(${session_id}+"님 회원정보를 삭제하겠습니까?"){
						location.href="/member/delete";
					})
				}
				</script>
				
			</form>
		</section>

		<footer>
			<div id="footer_wrap">
				<div id="footer_cont">
					<div id="fl_l">
						<a href="#"></a>
						<p>© COOKIT ALL RIGHTS RESERVED</p>
					</div>
					<div id="fl_c">
						<ul>
							<li><a href="#">이용약관</a></li>
							<li><a href="#">개인정보처리 방침</a></li>
							<li><a href="#">법적고지</a></li>
							<li><a href="#">사업자정보 확인</a></li>
						</ul>
						<div id="fl_c_info">
							<p>씨제이제일제당(주)</p>
							<p>대표이사 : 손경식,강신호,신현재</p>
							<p>사업자등록번호 : 104-86-09535</p>
							<p>주소 : 서울 중구 동호로 330 CJ제일제당 센터 (우) 04560</p>
							<p>통신판매업신고 중구 제 07767호</p>
							<p>개인정보보호책임자 : 조영민</p>
							<p>이메일 : cjon@cj.net</p>
							<p>호스팅제공자 : CJ올리브네트웍스㈜</p>
							<p>고객님은 안전거래를 위해 현금등으로 결제시 LG U+ 전자 결제의 매매보호(에스크로) 서비스를 이용하실 수 있습니다. <a href="#">가입 사실 확인</a></p>
						</div>
					</div>
					<div id="fl_r">
						<span>cj그룹계열사 바로가기 ▼</span>
						<dl>
							<dt>고객행복센터</dt>
								<dd>1688-1920</dd>
						</dl>
						<a href="#">1:1문의</a>						
					</div>
				</div>
			</div>
		
		
		
		</footer>
	</body>
</html>