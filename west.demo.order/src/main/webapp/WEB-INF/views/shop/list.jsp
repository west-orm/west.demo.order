<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<title>订餐吧</title>

		<meta name="description" content="overview &amp; stats" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />

		<!-- basic styles -->

		<link href="${resource}/assets/css/bootstrap.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="${resource}/assets/css/font-awesome.min.css" />

		<!--[if IE 7]>
		  <link rel="stylesheet" href="${resource}/assets/css/font-awesome-ie7.min.css" />
		<![endif]-->

		<!-- page specific plugin styles -->

		<!-- fonts -->

		<link rel="stylesheet" href="${resource}/assets/css/ace-fonts.css" />

		<!-- ace styles -->

		<link rel="stylesheet" href="${resource}/assets/css/ace.min.css" />
		<link rel="stylesheet" href="${resource}/assets/css/ace-rtl.min.css" />
		<link rel="stylesheet" href="${resource}/assets/css/ace-skins.min.css" />

		<!--[if lte IE 8]>
		  <link rel="stylesheet" href="${resource}/assets/css/ace-ie.min.css" />
		<![endif]-->

		<!-- inline styles related to this page -->

		<!-- ace settings handler -->

		<script src="${resource}/assets/js/ace-extra.min.js"></script>

		<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

		<!--[if lt IE 9]>
		<script src="${resource}/assets/js/html5shiv.js"></script>
		<script src="${resource}/assets/js/respond.min.js"></script>
		<![endif]-->
	</head>

	<body>
		<div class="navbar navbar-default" id="navbar">
			<script type="text/javascript">
				try{ace.settings.check('navbar' , 'fixed')}catch(e){}
			</script>
			
			<c:import url="/header"></c:import>
		</div>

		<div class="main-container" id="main-container">
			<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>

			<div class="main-container-inner">
				<a class="menu-toggler" id="menu-toggler" href="#">
					<span class="menu-text"></span>
				</a>

				<c:import url="/sidebar"></c:import>

				<div class="main-content">
					<div class="breadcrumbs" id="breadcrumbs">
						<script type="text/javascript">
							try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
						</script>

						<ul class="breadcrumb">
							<li>
								<i class="icon-home home-icon"></i>
								<a href="#">今日订单</a>
							</li>
							<li class="active">清单</li>
						</ul><!-- .breadcrumb -->

						<div class="nav-search" id="nav-search">
							<form class="form-search">
								<span class="input-icon">
									<input type="text" placeholder="Search ..." class="nav-search-input" id="nav-search-input" autocomplete="off" />
									<i class="icon-search nav-search-icon"></i>
								</span>
							</form>
						</div><!-- #nav-search -->
					</div>

					<div class="page-content">

						<div class="row">

<div class="col-xs-12">
<form action="${ctx}/shop/list" name="form1">
<input type="hidden" value="${page.pageNo}" name="pageNo">
<input type="hidden" value="${page.pageSize}" name="pageSize">
										<h3 class="header smaller lighter blue">商家清单</h3>
										<div class="">
											<button onclick="location.href='${ctx}/shop/add';return false">录入商家</button>
										</div>

										<div class="table-responsive">
											<div id="sample-table-2_wrapper" class="dataTables_wrapper" role="grid">
											<table id="sample-table-2" class="table table-striped table-bordered table-hover dataTable" aria-describedby="sample-table-2_info">
												<thead>
													<tr role="row"><th class="center sorting_disabled" role="columnheader" rowspan="1" colspan="1" aria-label="" style="width: 77px;">
															<label>
																<input type="checkbox" class="ace">
																<span class="lbl"></span>
															</label>
														</th>
														<th class="sorting" role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1" colspan="1" aria-label="Domain: activate to sort column ascending" style="width: 208px;">名称</th>
														<th class="sorting" role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1" colspan="1" aria-label="Price: activate to sort column ascending" style="width: 137px;">地址</th>
														<th class="hidden-480 sorting" role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1" colspan="1" aria-label="Clicks: activate to sort column ascending" style="width: 148px;">创建时间</th>
														<th class="sorting" role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1" colspan="1" aria-label="Update: activate to sort column ascending" style="width: 224px;">
															<i class="icon-time bigger-110 hidden-480"></i>
															开始时间
														</th>
														<th class="hidden-240 sorting" role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1" colspan="1" aria-label="Status: activate to sort column ascending" style="width: 219px;">发起人</th>
														<th class="hidden-240 sorting" role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1" colspan="1" aria-label="Status: activate to sort column ascending" style="width: 219px;">状态</th>
														<th class="sorting_disabled" role="columnheader" rowspan="1" colspan="1" aria-label="" style="width: 215px;"></th>
														</tr>
												</thead>

												
											<tbody role="alert" aria-live="polite" aria-relevant="all">
											<c:forEach items="${page.data}" var="act">
											<tr class="odd">
														<td class="center  sorting_1">
															<label>
																<input type="checkbox" class="ace">
																<span class="lbl"></span>
															</label>
														</td>

														<td class="hidden-480">
															${act.name}
														</td>
														<td class=" ">${act.address}</td>
														<td >
														<fmt:formatDate value="${act.createTime}" pattern="yyyy-MM-dd HH时" />
														</td>
														<td class=" ">
														</td>
														<td >
															<span class="label label-sm label-warning">${act.creater}</span>
														</td>
														<td >
															<span class="label label-sm label-warning"></span>
														</td>

														<td class=" ">
															<div class="visible-md visible-lg hidden-sm hidden-xs action-buttons">
																<a class="blue" href="${ctx}/shop/add?id=${act.id}" title="修改商家信息">
																	<i class="icon-edit bigger-130"></i>
																</a>
																<a class="green" href="${ctx}/activity/orderdetail/list?id=${act.id}" title="下单">
																	<i class="icon-pencil bigger-130"></i>
																</a>
																<a class="red" href="#" title="订单作废" onclick="deleteOrder(${act.id})">
																	<i class="icon-trash bigger-130"></i>
																</a>
															</div>
															
														</td>
													</tr>
													</c:forEach>
													
													
													</tbody></table>
												
													<west:Pagination page="${page}"></west:Pagination>
													</div>
										</div>
										</form>
									</div>

					</div><!-- /.page-content -->
				</div><!-- /.main-content -->

				<c:import url="/setting"></c:import>
			</div><!-- /.main-container-inner -->

			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="icon-double-angle-up icon-only bigger-110"></i>
			</a>
		</div><!-- /.main-container -->

		<!-- basic scripts -->

		<!--[if !IE]> -->

		<script type="text/javascript">
			window.jQuery || document.write("<script src='${resource}/assets/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
		</script>

		<!-- <![endif]-->

		<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='${resource}/assets/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
</script>
<![endif]-->

		<script type="text/javascript">
			if("ontouchend" in document) document.write("<script src='${resource}/assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
		<script src="${resource}/assets/js/bootstrap.min.js"></script>
		<script src="${resource}/assets/js/typeahead-bs2.min.js"></script>

		<!-- page specific plugin scripts -->

		<!--[if lte IE 8]>
		  <script src="${resource}/assets/js/excanvas.min.js"></script>
		<![endif]-->

		<script src="${resource}/assets/js/jquery-ui-1.10.3.custom.min.js"></script>
		<script src="${resource}/assets/js/jquery.ui.touch-punch.min.js"></script>
		<script src="${resource}/assets/js/jquery.slimscroll.min.js"></script>
		<script src="${resource}/assets/js/jquery.easy-pie-chart.min.js"></script>
		<script src="${resource}/assets/js/jquery.sparkline.min.js"></script>
		<script src="${resource}/assets/js/flot/jquery.flot.min.js"></script>
		<script src="${resource}/assets/js/flot/jquery.flot.pie.min.js"></script>
		<script src="${resource}/assets/js/flot/jquery.flot.resize.min.js"></script>

		<!-- ace scripts -->

		<script src="${resource}/assets/js/ace-elements.min.js"></script>
		<script src="${resource}/assets/js/ace.min.js"></script>

		<!-- inline scripts related to this page -->

		<script type="text/javascript">
			jQuery(function($) {
				
				
				
				//Android's default browser somehow is confused when tapping on label which will lead to dragging the task
				//so disable dragging when clicking on label
				var agent = navigator.userAgent.toLowerCase();
			
			
			
			
			})
			
			function deleteOrder(id)
			{
				var delurl = "${ctx}/activity/delete?id="+id;
				location.href = delurl;

			}
		</script>
	</body>
</html>
