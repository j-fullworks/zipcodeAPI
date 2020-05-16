$(function() {
	$('#getAddressBtn').on('click', function() {
		var params = {
				"zipcode" : $('#zipcode').val()
		};
		$.ajax({
			url : 'getAddress',
			type: 'POST',
			contentType: "application/json",
	        data: JSON.stringify(params),
			dataType : 'json',
			async: false,
			success: function (data) {
				$("#dispAddress").empty();
			    var dispAddress = document.getElementById("dispAddress");
				var table = document.createElement("table");
				table.setAttribute("border","2");
				table.setAttribute("cellpadding","15");
				table.setAttribute("style","margin :15px");

			    $(data.results).each(function(index, result){
					table.appendChild(createRow("郵便番号",result.zipcode));
					table.appendChild(createRow("都道府県コード",result.prefcode));
					table.appendChild(createRow("都道府県名",result.address1));
					table.appendChild(createRow("市区町村名",result.address2));
					table.appendChild(createRow("町域名",result.address3));
					table.appendChild(createRow("都道府県名カナ",result.kana1));
					table.appendChild(createRow("市区町村名カナ",result.kana2));
					table.appendChild(createRow("町域名カナ",result.kana3));
			    });
				dispAddress.appendChild(table);
			}
		});
	});
});

/**
 * 住所情報行を作成する
 * @param header
 * @param value
 * @returns
 */
function createRow(header , value){

	var tr = document.createElement("tr");
	var th = document.createElement("th");
	th.append(header);
	var td = document.createElement("td");
	td.append(value);
	tr.appendChild(th);
	tr.appendChild(td);
	return tr;
}