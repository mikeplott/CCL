function checkBox(t) {
    var el = document.getElementById($(t).attr('id'));
    var id = ($(t).attr('id'));
    var check = document.getElementById($(t).attr('id')).getAttribute('checked');
    var input = document.getElementById('input' + id);
    if (check == 'false') {
      el.setAttribute('checked', '');
      el.setAttribute('checked', true);
      el.setAttribute('value', '');
      el.setAttribute('value', true);
      el.setAttribute('class', '');
      el.setAttribute('class', 'fa fa-check-square fa-2x');
      input.setAttribute('value', true);
    }
    else {
      el.setAttribute('checked', '');
      el.setAttribute('checked', 'false');
      el.setAttribute('value', '');
      el.setAttribute('value', false);
      el.setAttribute('class', '');
      input.setAttribute('value', false);
      el.setAttribute('class', 'fa fa-square-o fa-2x');
    }
  }

function capitalizeEachWord(str) {
    return str.replace(/\w\S*/g, function(txt) {
        return txt.charAt(0).toUpperCase() + txt.substr(1).toLowerCase();
    });
}

function inventoryDash(Event) {
    event.preventDefault();

    var row = $('#myContainer');
    row.empty();

    var rightDiv = $('#myButtons');

    if (rightDiv != null) {
        rightDiv.remove();
    }

    var myHeader = document.getElementById('myHeader');
    myHeader.innerHTML = "Inventory Search";

    var div = document.createElement('div');
    div.setAttribute('class', 'row');

    var div1 = document.createElement('div');
    div1.setAttribute('class', 'col-md-4');

    var div2 = document.createElement('div');
    div2.setAttribute('class', 'col-md-4');

    var div3 = document.createElement('div');
    div3.setAttribute('class', 'col-md-4');


    var searchForm = document.createElement('form');
    searchForm.setAttribute('id', 'invSearch');

    var searchBar = document.createElement('input');
    searchBar.setAttribute('type', 'text');
    searchBar.setAttribute('class', 'form-control');
    searchBar.setAttribute('placeholder', 'Search...');
    searchBar.setAttribute('name', 'invBar');
    searchBar.setAttribute('id', 'invInput');

    var searchLabel = document.createElement('label');
    searchLabel.setAttribute('for', 'invInput');
    searchLabel.setAttribute('id', 'searchLabel');
    searchLabel.innerHTML = "Product lookup";

    var searchBtn = document.createElement('button');
    searchBtn.setAttribute('class', 'btn btn-primary');
    searchBtn.setAttribute('id', 'mainSearchBtn');
    searchBtn.setAttribute('type', 'submit');
    searchBtn.setAttribute('onclick', 'productSearch(event)');
    searchBtn.innerHTML = "Search";

    div1.appendChild(searchLabel);
    div2.appendChild(searchBar);
    div3.appendChild(searchBtn);

    div.appendChild(div1);
    div.appendChild(div2);
    div.appendChild(div3);

    searchForm.append(div);

    row.append(searchForm);

    var createLabel = document.createElement('label');
    createLabel.setAttribute('class', 'btn btn-primary selector');
    createLabel.innerHTML = "Inventory Creation";

    var createBtn = document.createElement('input');
    createBtn.setAttribute('type', 'radio');
    createBtn.setAttribute('name', 'createBtn');
    createBtn.setAttribute('id', 'option4');
    createBtn.setAttribute('autocomplete', 'off');
    createBtn.setAttribute('onclick', 'wineView()');

    var searchTitle = document.createElement('label');
    searchTitle.setAttribute('class', 'btn btn-primary selector');
    searchTitle.innerHTML = "Inventory Search";

    var searchBtn = document.createElement('input');
    searchBtn.setAttribute('type', 'radio');
    searchBtn.setAttribute('name', 'searchBtn');
    searchBtn.setAttribute('id', 'option5');
    searchBtn.setAttribute('autocomplete', 'off');
    searchBtn.setAttribute('onclick', 'inventoryDash(event)');

    var deleteBtn = document.createElement('input');
    deleteBtn.setAttribute('type', 'radio');
    deleteBtn.setAttribute('name', 'deleteBtn');
    deleteBtn.setAttribute('id', 'option6');
    deleteBtn.setAttribute('autocomplete', 'off');
    deleteBtn.setAttribute('onclick', 'inventoryDeletion(event)');

    var deleteLabel = document.createElement('label');
    deleteLabel.setAttribute('class', 'btn btn-primary selector');
    deleteLabel.innerHTML = "Inventory Deletion";

    var zeContainer = $('#zeNav');

    var newDiv = document.createElement('div');
    newDiv.setAttribute('class', 'col-md-6 btn-group');
    newDiv.setAttribute('data-toggle', 'buttons');
    newDiv.setAttribute('id', 'myButtons');

    searchTitle.append(searchBtn);
    createLabel.append(createBtn);
    deleteLabel.append(deleteBtn);

    newDiv.append(createLabel);
    newDiv.append(searchTitle);
    newDiv.append(deleteLabel);

    zeContainer.append(newDiv);
}

function wineView(Event) {
    event.preventDefault();

    var row = $('#myContainer');
    if (row != null) {
        row.empty();
    }

    var wineHeader = document.createElement('h1');
    wineHeader.setAttribute('id', 'wineHeader');
    wineHeader.innerHTML = "Wine Creation Sheet";

    row.append(wineHeader);

    var theNewDiv = $('#zeNav');

    var newDiv = $('#myButtons');

    newDiv.empty();

    var dynNav = $('#theNav');

    var wineLabel = document.createElement('label');
    wineLabel.setAttribute('class', 'btn btn-primary selector');
    wineLabel.innerHTML = "Wine";

    var wineBtn = document.createElement('input');
    wineBtn.setAttribute('type', 'radio');
    wineBtn.setAttribute('name', 'options');
    wineBtn.setAttribute('id', 'option1');
    wineBtn.setAttribute('autocomplete', 'off');
    wineBtn.setAttribute('onclick', 'createWineView()');

    var beerLabel = document.createElement('label');
    beerLabel.setAttribute('class', 'btn btn-primary selector');
    beerLabel.innerHTML = "Beer";

    var beerBtn = document.createElement('input');
    beerBtn.setAttribute('type', 'radio');
    beerBtn.setAttribute('name', 'options');
    beerBtn.setAttribute('id', 'option2');
    beerBtn.setAttribute('autocomplete', 'off');
    beerBtn.setAttribute('onclick', 'createBeerView()');

    var liquorLabel = document.createElement('label');
    liquorLabel.setAttribute('class', 'btn btn-primary selector');
    liquorLabel.innerHTML = "Liquour";

    var liquorBtn = document.createElement('input');
    liquorBtn.setAttribute('type', 'radio');
    liquorBtn.setAttribute('name', 'options');
    liquorBtn.setAttribute('id', 'option3');
    liquorBtn.setAttribute('autocomplete', 'off');
    liquorBtn.setAttribute('onclick', 'createLiquorView()');

    var backLabel = document.createElement('label');
    backLabel.setAttribute('class', 'btn btn-primary selector');
    backLabel.innerHTML = "Inventory Search";

    var backBtn = document.createElement('input');
    backBtn.setAttribute('type', 'radio');
    backBtn.setAttribute('name', 'options');
    backBtn.setAttribute('id', 'option7');
    backBtn.setAttribute('autocomplete', 'off');
    backBtn.setAttribute('onclick', 'inventoryDash(event)');

    wineLabel.append(wineBtn);
    beerLabel.append(beerBtn);
    liquorLabel.append(liquorBtn);
    backLabel.append(backBtn);

    newDiv.append(backLabel);
    newDiv.append(wineLabel);
    newDiv.append(beerLabel);
    newDiv.append(liquorLabel);

    newDiv.addClass('createGroup');

    theNewDiv.append(newDiv);

    document.getElementById('myHeader').innerHTML = "Inventory Management";

    createWineView();
}

function createWineView() {
  $.get('/product-models', function(data) {
    var liquor = null;
    var beer = null;
    var wine = data.wine;
    var sizes = data.sizes
    productViewCreation(beer, liquor, wine, sizes);
  });
}

function createBeerView() {
  $.get('/product-models', function(data) {
    var liquor = null;
    var beer = data.beer;
    var wine = null;
    var sizes = data.sizes
    productViewCreation(beer, liquor, wine, sizes);
  });
}

function createLiquorView() {
  $.get('/product-models', function(data) {
    var liquor = data.liquor;
    var beer = null;
    var wine = null;
    var sizes = data.sizes
    productViewCreation(beer, liquor, wine, sizes);
  });
}

function productViewCreation(beer, liquor, wine, sizes) {
  var row = $('#myContainer');
  row.empty();

  var myForm = document.createElement('form');
  myForm.setAttribute('name', 'wineForm');
  myForm.setAttribute('id', 'theWineForm');

  var i = 0;
  var fieldset;
  var productHeader = document.createElement('h1');
  productHeader.setAttribute('id', 'productHeader');

  if (wine != null) {
    fieldset = wine;
    productHeader.innerHTML = 'Wine Sheet';
  }
  else if (liquor != null) {
    fieldset = liquor;
    productHeader.innerHTML = 'Liquor Sheet';
  }
  else {
    fieldset = beer;
    productHeader.innerHTML = 'Beer Sheet';
  }

  var row1 = document.createElement('div');
  row1.setAttribute('class', 'row theRows');
  row1.setAttribute('id', 'row1');

  var row2 = document.createElement('div');
  row2.setAttribute('class', 'row theRows');
  row2.setAttribute('id', 'row2');

  var row3 = document.createElement('div');
  row3.setAttribute('class', 'row theRows');
  row3.setAttribute('id', 'row3');

  var row4 = document.createElement('div');
  row4.setAttribute('class', 'row theRows');
  row4.setAttribute('id', 'row4');

  for (var field in fieldset) {
    i++;

    var k = field.toLowerCase();

    if (k != 'id') {
      var dataDiv = document.createElement('div');
      dataDiv.setAttribute('class', 'col-md-2');
      if (fieldset.importer != null) {
        dataDiv.setAttribute('id', 'wine' + k);
      }
      else if (fieldset.distillery != null) {
        dataDiv.setAttribute('id', 'liquor' + k);
      }
      else {
        dataDiv.setAttribute('id', 'beer' + k);
      }

      if (k == 'casesize') {

        var label = document.createElement('label');
        label.setAttribute('for', 'selector');
        label.innerHTML = k;

        var input = document.createElement('select');
        input.setAttribute('name', 'selector');
        input.setAttribute('class', 'form-control');
        input.setAttribute('id', 'selector');

        for (var s = 0; s < sizes.length; s++) {
          var size = sizes[s].split('_').join(' ');

          var option = document.createElement('option');
          option.setAttribute('value', sizes[s]);
          option.innerHTML = capitalizeEachWord(size);

          input.appendChild(option);
        }

        dataDiv.appendChild(label);
        dataDiv.appendChild(input);

        if (i >= 13 && i < 20) {
          row3.appendChild(dataDiv);
        }
      }
      else if (k == 'exclusive' || k == 'dualstate' || k == 'domestic' || k == 'seasonal') {
        var iclass = document.createElement('i');
        iclass.setAttribute('class', 'fa fa-square-o fa-2x');
        iclass.setAttribute('onclick', 'checkBox($(this))');
        iclass.setAttribute('id', k);
        iclass.setAttribute('checked', 'false');

        var hidInput = document.createElement('input');
        hidInput.setAttribute('type', 'hidden');
        hidInput.setAttribute('value', 'false');
        hidInput.setAttribute('name', k);
        hidInput.setAttribute('id', 'input' + k);

        var label = document.createElement('label');
        label.setAttribute('for', 'input' + i);
        label.innerHTML = k;

        dataDiv.appendChild(label);
        dataDiv.appendChild(hidInput);
        dataDiv.appendChild(iclass);

        if (i >= 13 && i < 20) {
          row3.appendChild(dataDiv);
        }
        else {
          row4.appendChild(dataDiv);
        }
      }
      else if (k == 'lotdate' || k == 'expirationdate') {
        var input = document.createElement('input');
        input.setAttribute('type', 'date');
        input.setAttribute('name', k);
        input.setAttribute('class', 'form-control');
        input.setAttribute('id', 'input' + i);

        var label = document.createElement('label');
        label.setAttribute('for', 'input' + i);
        label.innerHTML = k;

        dataDiv.appendChild(label);
        dataDiv.appendChild(input);
      }
      else {
        var input = document.createElement('input');
        input.setAttribute('type', 'text');
        input.setAttribute('name', k);
        input.setAttribute('class', 'form-control');
        input.setAttribute('id', 'input' + i);

        var label = document.createElement('label');
        label.setAttribute('for', 'input' + i);
        label.innerHTML = k;

        dataDiv.appendChild(label);
        dataDiv.appendChild(input);
      }

        if (i <= 7) {
          row1.appendChild(dataDiv);
        }
        else if (i > 7 && i <= 13) {
          row2.appendChild(dataDiv);
        }
        else if (i > 13 && i <= 19) {
          row3.appendChild(dataDiv);
        }
        else {
          row4.appendChild(dataDiv);
        }
      }
    }

    var lastDiv = document.createElement('div');
    lastDiv.setAttribute('class', 'col-md-2 col-md-offset-8');

    var formButton = document.createElement('button');
    formButton.setAttribute('type', 'submit');
    formButton.setAttribute('class', 'btn btn-primary');

    if (fieldset.importer != null) {
      formButton.setAttribute('id', 'wineCreater');
      formButton.setAttribute('onclick', 'createWine(event)');
      formButton.innerHTML = 'Submit';

      lastDiv.appendChild(formButton);

      row4.appendChild(lastDiv);
    }
    else if (fieldset.distillery != null) {
      formButton.setAttribute('id', 'liquorCreater');
      formButton.setAttribute('onclick', 'createLiquor(event)');
      formButton.innerHTML = 'Submit';

      lastDiv.setAttribute('class', 'col-md-2');

      lastDiv.appendChild(formButton);

      row3.appendChild(lastDiv);
    }
    else {
      formButton.setAttribute('id', 'beerCreater');
      formButton.setAttribute('onclick', 'createBeer(event)');
      formButton.innerHTML = 'Submit';

      lastDiv.setAttribute('class', 'col-md-2 col-md-offset-4');

      lastDiv.appendChild(formButton);

      row4.appendChild(lastDiv);
    }
    myForm.appendChild(row1);
    myForm.appendChild(row2);
    myForm.appendChild(row3);
    myForm.appendChild(row4);
    row.append(productHeader);
    row.append(myForm);
  }

function createWine(event) {
    event.preventDefault();

    var f = $('#theWineForm');
    var vin = f.find('[name=vintage]').val();
    var vari = f.find('[name=varietal]').val();
    var iColor = f.find('[name=color]').val();
    var imp = f.find('[name=importer]').val();
    var name = f.find('[name=name]').val();
    var desc = f.find('[name=description]').val();
    var itemC = f.find('[name=itemcode]').val();
    var orig = f.find('[name=origin]').val();
    var vol = f.find('[name=volume]').val();
    var frontP = f.find('[name=frontprice]').val();
    var tenCP = f.find('[name=tencaseprice]').val();
    var twentyFCP = f.find('[name=twentyfivecaseprice]').val();
    var theCost = f.find('[name=cost]').val();
    var bottleW = f.find('[name=bottleweight]').val();
    var caseW = f.find('[name=caseweight]').val();
    var quantity = f.find('[name=quantity]').val();
    var wCS = f.find('[name=selector]').val();
    var exclu = f.find('[name=exclusive]').val();
    var dualS = f.find('[name=dualstate]').val();

    $.ajax({
        url: '/create-wine',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify({
            'vintage': vin,
            'varietal': vari,
            'color': iColor,
            'importer': imp,
            'name': name,
            'description': desc,
            'itemCode': itemC,
            'origin': orig,
            'volume': vol,
            'frontPrice': frontP,
            'tenCasePrice': tenCP,
            'twentyFiveCasePrice': twentyFCP,
            'cost': theCost,
            'bottleWeight': bottleW,
            'caseWeight': caseW,
            'quantity': quantity,
            'exclusive': exclu,
            'dualState': dualS,
            'caseSize': wCS
        }),
        success: function(data) {
            document.getElementById('theWineForm').reset();
        }
    });
}

function createBeer(event) {
    event.preventDefault();

    var f = $('#theWineForm');
    var vin = f.find('[name=lotdate]').val();
    var vari = f.find('[name=expirationdate]').val();
    var iColor = f.find('[name=beertype]').val();
    var imp = f.find('[name=brewery]').val();
    var name = f.find('[name=name]').val();
    var desc = f.find('[name=description]').val();
    var itemC = f.find('[name=itemcode]').val();
    var orig = f.find('[name=origin]').val();
    var vol = f.find('[name=volume]').val();
    var frontP = f.find('[name=frontprice]').val();
    var tenCP = f.find('[name=tencaseprice]').val();
    var twentyFCP = f.find('[name=twentyfivecaseprice]').val();
    var theCost = f.find('[name=cost]').val();
    var bottleW = f.find('[name=bottleweight]').val();
    var caseW = f.find('[name=caseweight]').val();
    var quantity = f.find('[name=quantity]').val();
    var exclu = f.find('[name=exclusive]').val();
    var dualS = f.find('[name=dualstate]').val();
    var theDomes = f.find('[name=domestic]').val();
    var theSeasons = f.find('[name=seasonal]').val();
    var wCS = f.find('[name=selector]').val();

    $.ajax({
        url: '/create-beer',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify({
            'lotDate': vin,
            'expirationDate': vari,
            'beerType': iColor,
            'brewery': imp,
            'domestic': theDomes,
            'seasonal': theSeasons,
            'name': name,
            'description': desc,
            'itemCode': itemC,
            'origin': orig,
            'volume': vol,
            'frontPrice': frontP,
            'tenCasePrice': tenCP,
            'twentyFiveCasePrice': twentyFCP,
            'cost': theCost,
            'bottleWeight': bottleW,
            'caseWeight': caseW,
            'quantity': quantity,
            'exclusive': exclu,
            'dualState': dualS,
            'caseSize': wCS
        }),
        success: function(data) {
            document.getElementById('theWineForm').reset();
        }
    });
}

function createLiquor(event) {
    event.preventDefault();

    var f = $('#theWineForm');
    var vin = f.find('[name=liquortype]').val();
    var vari = f.find('[name=distillery]').val();
    var iColor = f.find('[name=name]').val();
    var imp = f.find('[name=description]').val();
    var name = f.find('[name=itemcode]').val();
    var desc = f.find('[name=origin]').val();
    var itemC = f.find('[name=volume]').val();
    var orig = f.find('[name=frontprice]').val();
    var vol = f.find('[name=tencaseprice]').val();
    var frontP = f.find('[name=twentyfivecaseprice]').val();
    var tenCP = f.find('[name=cost]').val();
    var twentyFCP = f.find('[name=bottleweight]').val();
    var theCost = f.find('[name=caseweight]').val();
    var bottleW = f.find('[name=quantity]').val();
    var exclu = f.find('[name=exclusive]').val();
    var dualS = f.find('[name=dualstate]').val();
    var wCS = f.find('[name=selector]').val();

    $.ajax({
        url: '/create-liquor',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify({
            'liquorType': vin,
            'distillery': vari,
            'name': iColor,
            'description': imp,
            'itemCode': name,
            'origin': desc,
            'volume': itemC,
            'frontPrice': orig,
            'tenCasePrice': vol,
            'twentyFiveCasePrice': frontP,
            'cost': tenCP,
            'bottleWeight': twentyFCP,
            'caseWeight': theCost,
            'quantity': bottleW,
            'exclusive': exclu,
            'dualState': dualS,
            'caseSize': wCS
        }),
        success: function(data) {
            document.getElementById('theWineForm').reset();
        }
    });
}

function inventoryDeletion(event) {
    event.preventDefault();

    var row = $('#myContainer');
    row.empty();

    var myForm = document.createElement('form');
    myForm.setAttribute('name', 'deleteForm');
    myForm.setAttribute('id', 'theDeleteForm');

    document.getElementById('myHeader').innerHTML = "Inventory Deletion";

    var theDiv1 = document.createElement('div');
    theDiv1.setAttribute('class', 'col-md-3');
    theDiv1.setAttribute('id', 'bar1');

    var theDiv2 = document.createElement('div');
    theDiv2.setAttribute('class', 'col-md-3');
    theDiv2.setAttribute('id', 'bar2');

    var theDiv3 = document.createElement('div');
    theDiv3.setAttribute('class', 'col-md-3');
    theDiv3.setAttribute('id', 'bar3');

    var theDiv4 = document.createElement('div');
    theDiv4.setAttribute('class', 'col-md-3');
    theDiv4.setAttribute('id', 'bar4');

    var input1 = document.createElement('input');
    input1.setAttribute('type', 'text');
    input1.setAttribute('name', 'itemCode');
    input1.setAttribute('class', 'form-control');
    input1.setAttribute('id', 'input1');

    var label1 = document.createElement('label');
    label1.setAttribute('for', 'input1');
    label1.innerHTML = "Search By Item Code";

    var input2 = document.createElement('input');
    input2.setAttribute('type', 'text');
    input2.setAttribute('name', 'itemName');
    input2.setAttribute('class', 'form-control');
    input2.setAttribute('id', 'input2');

    var label2 = document.createElement('label');
    label2.setAttribute('for', 'input2');
    label2.innerHTML = "Search By Item Name";

    var input3 = document.createElement('input');
    input3.setAttribute('type', 'text');
    input3.setAttribute('name', 'importer');
    input3.setAttribute('class', 'form-control');
    input3.setAttribute('id', 'input3');

    var label3 = document.createElement('label');
    label3.setAttribute('for', 'input3');
    label3.innerHTML = "Search By Importer/Distillery/Brewery";

    var input4 = document.createElement('input');
    input4.setAttribute('type', 'text');
    input4.setAttribute('name', 'productType');
    input4.setAttribute('class', 'form-control');
    input4.setAttribute('id', 'input4');

    var label4 = document.createElement('label');
    label4.setAttribute('for', 'input4');
    label4.innerHTML = "Search By Product Type";

    var srcBtn = document.createElement('button');
    srcBtn.setAttribute('class', 'btn btn-primary');
    srcBtn.setAttribute('onclick', 'updateProduct(event)');
    srcBtn.setAttribute('id', 'mySearchBtn');
    srcBtn.innerHTML = "Submit";

    var theDiv5 = document.createElement('div');
    theDiv5.setAttribute('class', 'col-md-3');
    theDiv5.setAttribute('id', 'bar5');

    var theDiv6 = document.createElement('div');
    theDiv6.setAttribute('class', 'col-md-3');

    theDiv5.append(srcBtn);

    theDiv1.append(label1);
    theDiv1.append(input1);

    theDiv2.append(label2);
    theDiv2.append(input2);

    theDiv3.append(label3);
    theDiv3.append(input3);

    theDiv4.append(label4);
    theDiv4.append(input4);

    myForm.append(theDiv1);
    myForm.append(theDiv2);
    myForm.append(theDiv3);
    myForm.append(theDiv5);

    row.append(myForm);
}

function productSearch(event) {
    event.preventDefault();
    $('#tableRow').remove();
    var f = $('#invSearch');
    var item = f.find('[name=invBar]').val();
    $.ajax({
        url: '/search-products',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify({
          'item': item,
        }),
        success: function(data) {
            searchData(data);
        }
    });
}

function searchData(data) {
    var labels = ['itemCode', 'name', 'quantity', 'Case Size','brewery', 'distillery', 'importer', 'vintage','Lot Date', 'Expiration Date'];
    var theData = data.results;
    var theTable = document.createElement('table');
    theTable.setAttribute('class', 'table table-fixed-header table-bordered table-inverse table-hover table-responsive overflow-y:hidden');
    theTable.setAttribute('id', 'searchResults');
    var theHead = document.createElement('thead');
    theHead.setAttribute('class', 'header');
    var headerRow = document.createElement('tr');
    var list = theData[1];
    for (var key in theData[0]) {
      var theKey = key.toLowerCase();
      theKey = capitalizeEachWord(theKey);
      if (key != 'id' && key != 'wineID' && key != 'beerID' && key != 'liquorID' && key != 'liquor'
        && key != 'beer' && key != 'wine' && key != 'wineCaseSize' && key != 'beerCaseSize'
        && key != 'itemCode' && key != 'name' && key != 'quantity' && key != 'brewery'
        && key != 'distillery' && key != 'importer' && key != 'vintage' && key != 'liquorCaseSize'
        && key != 'lotDate' && key != 'expirationDate') {
        labels.push(key);
      }
    }
    for (var headerKey = 0; headerKey < labels.length; headerKey++) {
      var header = document.createElement('th');
      header.setAttribute('id', 'myTHS');
      if (labels[headerKey] == 'tenCasePrice') {
        header.innerHTML = '10 Case Price';
      }
      else if (labels[headerKey] == 'twentyFiveCasePrice') {
        header.innerHTML = '25 Case Price';
      }
      else {
        header.innerHTML = capitalizeEachWord(labels[headerKey]);
      }
      headerRow.appendChild(header);
    }
    theHead.appendChild(headerRow);
    theTable.appendChild(theHead);
    var tBody = document.createElement('tbody');
    tBody.setAttribute('class', 'myBody');
    theTable.appendChild(tBody);
    for (var i = 0; i < theData.length; i++) {
      var tRow = document.createElement('tr');
      var zeData = theData[i];
      var size = ['wineCaseSize', 'beerCaseSize', 'liquorCaseSize'];
      var casesize;
      if (zeData.wineCaseSize != null) {
        casesize = zeData.wineCaseSize;
      }
      else if (zeData.beerCaseSize != null) {
        casesize = zeData.beerCaseSize;
      }
      else {
        casesize = zeData.liquorCaseSize;
      }
      casesize = zeData.caseSize;
    for (var n = 0; n < labels.length; n++) {
      var deKey = labels[n];
      var theVal = zeData[deKey];
      var tCol = document.createElement('td');
      tCol.setAttribute('class', 'overflow-x:hidden');
      tCol.setAttribute('id', 'myTDS');
      tCol.innerHTML = theVal;
      if (deKey === 'Case Size') {
        tCol.innerHTML = casesize;
      }
      else if (deKey == 'Lot Date') {
        tCol.innerHTML = zeData.lotDate;
      }
      else if (deKey == 'Expiration Date') {
        tCol.innerHTML = zeData.expirationDate;
      }
      tRow.append(tCol);
    }
    var input = document.createElement('input');
    input.setAttribute('type', 'hidden');
    input.setAttribute('value', zeData.id);
    tRow.setAttribute('ondblclick', 'itemEntry(this)');
    tRow.append(input);
    tBody.append(tRow);
  }
  theTable.append(tBody);

  var row = $('#myContainer');
  row.append(theTable);
}

function updateProduct(data) {

    console.log(data);

    var rowDiv = document.createElement('div');
    rowDiv.setAttribute('class', 'row');

    var rowDiv1 = document.createElement('div');
    rowDiv.setAttribute('class', 'row');

    var rowDiv2 = document.createElement('div');
    rowDiv.setAttribute('class', 'row');

    var rowDiv3 = document.createElement('div');
    rowDiv.setAttribute('class', 'row');

    var rowDiv4 = document.createElement('div');
    rowDiv.setAttribute('class', 'row');

    var myCont = document.createElement('div');
    myCont.setAttribute('class', 'col-md-12');


    var theContainer = row;

    var theData = data;

    var theBeer = data.beer;
    var theLiquor = data.liquor;
    var theWine = data.wine;

    if (theBeer != null) {
        for (var l = 0; l < theBeer.length; l++) {
            for (var j in theBeer[l]) {
                var beer = theBeer[l];

                if (j != "id") {
                    var theDiv = document.createElement('div');
                    theDiv.setAttribute('class', 'col-md-2');
                    theDiv.setAttribute('id', "parent");

                    var theDiv2 = document.createElement('div');
                    theDiv2.setAttribute('class', 'col-md-1');
                    theDiv2.setAttribute('id', 'popup');

                    var input1;

                    if (j == "lotDate" || j == "expirationDate") {
                        console.log(beer[j]);
                        var date = JSON.parse(beer[j]);
                        console.log(date);
                        input1 = document.createElement('date');
                        input1.setAttribute('type', 'date');
                    }

                    if (j == "exclusive" || j == "dualState" || j == "seasonal" || j == "domestic") {
                        input1 = document.createElement('input');
                        input1.setAttribute('type', 'checkbox');
                        input1.setAttribute('class', 'form-control');
                        input1.setAttribute('value', beer[j]);
                    } else if (j == "caseSize") {
                        input1 = document.createElement('select');
                        input1.setAttribute('class', 'form-control');
                        input1.setAttribute('selected', beer[j]);

                        var o1 = document.createElement('option');
                        o1.setAttribute('value', 'ONE_PACK');
                        o1.innerHTML = "1 Pack";

                        var o2 = document.createElement('option');
                        o2.setAttribute('value', 'THREE_PACK');
                        o2.innerHTML = "3 Pack";

                        var o3 = document.createElement('option');
                        o3.setAttribute('value', 'SIX_PACK');
                        o3.innerHTML = "6 Pack";

                        var o4 = document.createElement('option');
                        o4.setAttribute('value', 'NINE_PACK');
                        o4.innerHTML = "9 Pack";

                        var o5 = document.createElement('option');
                        o5.setAttribute('value', 'TWELVE_PACK');
                        o5.innerHTML = "12 Pack";

                        var o6 = document.createElement('option');
                        o6.setAttribute('value', 'TWENTY_FOUR_PACK');
                        o6.innerHTML = "1 Pack";

                        var o7 = document.createElement('option');
                        o7.setAttribute('value', 'FIVE_SEVENTEEN_GAL_KEG');
                        o7.innerHTML = "5.17 Gallon Keg";

                        var o8 = document.createElement('option');
                        o8.setAttribute('value', 'SEVEN_SEVEN_FIVE_GAL_KEG');
                        o8.innerHTML = "7.75 Gallon Keg";

                        var o9 = document.createElement('option');
                        o9.setAttribute('value', 'FIFTEEN_FIVE_GAL_KEG');
                        o9.innerHTML = "15.5 Gallon Keg";

                        var o10 = document.createElement('option');
                        o10.setAttribute('value', 'TWENTY_LITRE_KEG');
                        o10.innerHTML = "20L Keg";

                        var o11 = document.createElement('option');
                        o11.setAttribute('value', 'FIFTY_LITRE_KEG');
                        o11.innerHTML = "50L Keg";

                        input1.append(o1);
                        input1.append(o2);
                        input1.append(o3);
                        input1.append(o4);
                        input1.append(o5);
                        input1.append(o6);
                        input1.append(o7);
                        input1.append(o8);
                        input1.append(o9);
                        input1.append(o10);
                        input1.append(o11);
                    } else {
                        input1 = document.createElement('input');
                        input1.setAttribute('type', 'text');
                        input1.setAttribute('class', 'form-control');
                        input1.setAttribute('value', beer[j]);
                    }

                    var label1 = document.createElement('label');
                    label1.setAttribute('for', j);
                    label1.innerHTML = j;

                    theDiv.append(label1);
                    theDiv.append(input1);
                    theDiv.append(theDiv2);

                    myCont.append(theDiv);

                    theContainer.append(myCont);
                }
            }
        }
    }

    if (theLiquor != null) {
        for (var i = 0; i < theLiquor.length; i++) {
            for (var k in theLiquor[i]) {
                var liquor = theLiquor[i];
                console.log(liquor[k]);
                if (k != "id") {
                    var theDiv = document.createElement('div');
                    theDiv.setAttribute('class', 'col-md-2 ' + k);
                    theDiv.setAttribute('id', "parent");

                    var theDiv2 = document.createElement('div');
                    theDiv2.setAttribute('class', 'col-md-1');
                    theDiv2.setAttribute('id', 'popup');

                    var input1;
                    if (k == "exclusive" || k == "dualState") {
                        input1 = document.createElement('input');
                        input1.setAttribute('type', 'checkbox');
                        input1.setAttribute('class', 'form-control');
                        input1.setAttribute('value', liquor[k]);
                    } else if (k == "caseSize") {
                        console.log(k == "liquorCaseSize");
                        input1 = document.createElement('select');
                        input1.setAttribute('class', 'form-control');
                        input1.setAttribute('selected', liquor[k]);

                        var o1 = document.createElement('option');
                        o1.setAttribute('value', 'ONE_PACK');
                        o1.innerHTML = "1 Pack";

                        var o2 = document.createElement('option');
                        o2.setAttribute('value', 'THREE_PACK');
                        o2.innerHTML = "3 Pack";

                        var o3 = document.createElement('option');
                        o3.setAttribute('value', 'SIX_PACK');
                        o3.innerHTML = "6 Pack";

                        var o4 = document.createElement('option');
                        o4.setAttribute('value', 'NINE_PACK');
                        o4.innerHTML = "9 Pack";

                        var o5 = document.createElement('option');
                        o5.setAttribute('value', 'TWELVE_PACK');
                        o5.innerHTML = "12 Pack";

                        var o6 = document.createElement('option');
                        o6.setAttribute('value', 'TWENTY_FOUR_PACK');
                        o6.innerHTML = "1 Pack";

                        var o7 = document.createElement('option');
                        o7.setAttribute('value', 'FIVE_SEVENTEEN_GAL_KEG');
                        o7.innerHTML = "5.17 Gallon Keg";

                        var o8 = document.createElement('option');
                        o8.setAttribute('value', 'SEVEN_SEVEN_FIVE_GAL_KEG');
                        o8.innerHTML = "7.75 Gallon Keg";

                        var o9 = document.createElement('option');
                        o9.setAttribute('value', 'FIFTEEN_FIVE_GAL_KEG');
                        o9.innerHTML = "15.5 Gallon Keg";

                        var o10 = document.createElement('option');
                        o10.setAttribute('value', 'TWENTY_LITRE_KEG');
                        o10.innerHTML = "20L Keg";

                        var o11 = document.createElement('option');
                        o11.setAttribute('value', 'FIFTY_LITRE_KEG');
                        o11.innerHTML = "50L Keg";

                        input1.append(o1);
                        input1.append(o2);
                        input1.append(o3);
                        input1.append(o4);
                        input1.append(o5);
                        input1.append(o6);
                        input1.append(o7);
                        input1.append(o8);
                        input1.append(o9);
                        input1.append(o10);
                        input1.append(o11);
                    } else {
                        input1 = document.createElement('input');
                        input1.setAttribute('name', k);
                        input1.setAttribute('type', 'text');
                        input1.setAttribute('class', 'form-control');
                        input1.setAttribute('value', liquor[k])
                    }

                    var label1 = document.createElement('label');
                    label1.setAttribute('for', k);
                    label1.setAttribute('class', k)
                    label1.innerHTML = k;

                    theDiv.append(label1);
                    theDiv.append(input1);
                    theDiv.append(theDiv2);

                    myCont.append(theDiv);

                    theContainer.append(myCont);
                }
            }
        }
    }

    if (theWine != null) {
        for (var k in theWine) {

            var theDiv = document.createElement('div');
            theDiv.setAttribute('class', 'col-md-2');
            theDiv.setAttribute('id', "parent");

            var theDiv2 = document.createElement('div');
            theDiv2.setAttribute('class', 'col-md-1');
            theDiv2.setAttribute('id', 'popup');

            var input1 = document.createElement('fieldset');
            input1.setAttribute('name', k);
            if (k === "exclusive" || k === "dualState") {
                input1.setAttribute('type', 'checkbox');
                input1.setAttribute('class', 'form-control ' + k);
            } else if (k === "wineCaseSize") {
                input1.setAttribute('type', 'radio');
                input1.setAttribute('class', 'form-control ' + k);
                input1.setAttribute('id', k);
            } else {
                input1.setAttribute('type', 'text');
                input1.setAttribute('class', 'form-control ' + k);
            }

            var label1 = document.createElement('label');
            label1.setAttribute('for', k);
            label1.innerHTML = k;

            theDiv.append(label1);
            theDiv.append(input1);
            theDiv.append(theDiv2);

            theContainer.append(theDiv);
        }
    }

    var lastDiv = document.createElement('div');
    lastDiv.setAttribute('class', 'col-md-2');

    var theBtn = document.createElement('button');
    theBtn.setAttribute('class', 'btn btn-primary');
    theBtn.setAttribute('id', 'srcBtn');
    theBtn.innerHTML = "Submit";

    lastDiv.append(theBtn);

    myCont.append(lastDiv);

    theContainer.append(myCont);

}

function orderEntry(event) {
    event.preventDefault();

    var row = $('#myContainer');
    row.empty();

    var div1 = document.createElement('div');
    div1.setAttribute('class', 'col-md-4');

    var div2 = document.createElement('div');
    div2.setAttribute('class', 'col-md-4');

    var div3 = document.createElement('div');
    div3.setAttribute('class', 'col-md-4');

    var acctForm = document.createElement('form');
    acctForm.setAttribute('id', 'acctForm');
    acctForm.setAttribute('class', 'form-inline');

    var input = document.createElement('input');
    input.setAttribute('type', 'text');
    input.setAttribute('class', 'form-control');
    input.setAttribute('name', 'acctInfo');
    input.setAttribute('placeholder', 'Search accts');
    input.setAttribute('id', 'acctInfo');

    var label = document.createElement('label');
    label.setAttribute('for', 'acctInfo');
    label.innerHTML = "Search accounts by account number or name";

    var btn = document.createElement('button');
    btn.setAttribute('class', 'btn btn-primary');
    btn.setAttribute('id', 'acctBtn');
    btn.setAttribute('type', 'submit');
    btn.setAttribute('onclick', 'acctsSearch(event)');
    btn.innerHTML = "Submit";

    div1.appendChild(label);
    div2.appendChild(input);
    div3.appendChild(btn);

    acctForm.appendChild(div1);
    acctForm.appendChild(div2);
    acctForm.appendChild(div3);

    row.append(acctForm);
}

function acctsSearch(event) {
    event.preventDefault();

    var f = $('#acctForm');
    var account = f.find('[name=acctInfo]').val();

    $.ajax({
        url: '/search-accounts',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify({
          'account': account,
        }),
        success: function(data) {
            accountData(data);
        }
    })
}

function accountData(data) {
    console.log(data);
    var myCont = $('#myContainer');
    var myTable = $('#accountResults');
    if (myTable != null) {
        myTable.empty();
    }
    var theData = data.account;
    var myLabels = ['Name', 'Address', 'City', 'State', 'Owner', 'ABC License', 'Zipcode', 'Phone Number', 'Account Number', 'Sales Rep', 'Pastdue'];
    var labels = [];
    var theTable = document.createElement('table');
    theTable.setAttribute('class', 'table table-fixed-header table-bordered table-inverse table-hover table-responsive overflow-y:hidden');
    theTable.setAttribute('id', 'accountResults');
    var headerRow = document.createElement('tr');
    headerRow.setAttribute('id', 'acctHeaders');
    for (var i = 0; i < myLabels.length; i++) {
        var headerCol = document.createElement('th');
        headerCol.innerHTML = myLabels[i];
        theTable.appendChild(headerCol);
    }
    for (var i = 0; i < theData.length; i++) {
        var zeData = theData[i];
        var zeId = theData[i].id;
        var repData = theData[i].salesRep;
        var rep = repData.lastName;
        var row = document.createElement('tr');
        row.setAttribute('ondblclick', 'inputOrders(this)');
        for (var k in theData[i]) {
            if (k != "abcExpiration" && k != "abcIssueDate" && k != "balance" && k != "businessLicense" && k != "buyer" && k != "classBWholeSaler" && k != "onPremise" && k != "receiver" && k != "specialEvent" && k != "supplier" && k != "id") {
                labels.push(k);
            }
        }
        for (var j = 0; j < labels.length; j++) {
            var key = labels[j];
            console.log(key);
            var col = document.createElement('td');
            if (key == 'salesReps') {
                col.innerHTML = zeData[key].lastName;
            }
            else {
                col.innerHTML = zeData[key];
            }
            row.appendChild(col);
        }
        var input = document.createElement('input');
        input.setAttribute('type', 'hidden');
        input.setAttribute('value', zeId);
        row.appendChild(input);
        theTable.appendChild(row);
        myCont.append(theTable);
    }
}

function inputOrders(t) {
    var id = t.lastChild.value;
    $.ajax({
        url: '/account',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify({
            'id': id
        }),
    success: function(data) {
        $('#accountResults').empty();
        var div = document.createElement('div');
        div.setAttribute('class', 'col-md-6');

        var input = document.createElement('input');
        input.setAttribute('type', 'text');
        input.setAttribute('name', 'input');
        input.setAttribute('readonly', true);
        input.setAttribute('class', 'form-control');
        input.setAttribute('value', data.accountNumber);

        var label = document.createElement('label');
        label.setAttribute('for', 'input');
        label.innerHTML = 'Account Number';

        div.append(label);
        div.append(input);

        var div1 = document.createElement('div');
        div1.setAttribute('class', 'col-md-6');

        var input1 = document.createElement('input');
        input1.setAttribute('type', 'text');
        input1.setAttribute('name', 'input1');
        input1.setAttribute('readonly', true);
        input1.setAttribute('class', 'form-control');
        input1.setAttribute('value', data.name);

        var label1 = document.createElement('label');
        label1.setAttribute('for', 'input1');
        label1.innerHTML = 'Account Name';

        div1.append(label1);
        div1.append(input1);

        var row = $('#myContainer');

        row.append(div);
        row.append(div1);
        orderData();
        }
    });
}

function orderData() {
    var div = document.createElement('div');
    div.setAttribute('class', 'col-md-12');
    div.setAttribute('id', 'itemDiv');

    var div1 = document.createElement('div');
    div1.setAttribute('class', 'col-md-4');

    var div2 = document.createElement('div');
    div2.setAttribute('class', 'col-md-4');

    var div3 = document.createElement('div');
    div3.setAttribute('class', 'col-md-4');

    var itemForm = document.createElement('form');
    itemForm.setAttribute('id', 'itemForm');
    itemForm.setAttribute('class', 'form-inline');

    var input = document.createElement('input');
    input.setAttribute('type', 'text');
    input.setAttribute('class', 'form-control');
    input.setAttribute('name', 'itemInfo');
    input.setAttribute('placeholder', 'Search items');
    input.setAttribute('id', 'itemInfo');

    var label = document.createElement('label');
    label.setAttribute('for', 'itemInfo');
    label.innerHTML = "Search items by itemcode or name";

    var btn = document.createElement('button');
    btn.setAttribute('class', 'btn btn-primary');
    btn.setAttribute('id', 'itemBtn');
    btn.setAttribute('type', 'submit');
    btn.setAttribute('onclick', 'itemSearch(event)');
    btn.innerHTML = "Submit";

    div1.appendChild(label);
    div2.appendChild(input);
    div3.appendChild(btn);

    itemForm.appendChild(div1);
    itemForm.appendChild(div2);
    itemForm.appendChild(div3);
    div.appendChild(itemForm);

    var row = $('#myContainer');

    row.append(div);
}

function itemSearch(event) {
    event.preventDefault();
    var f = $('#itemForm');
    var item = f.find('[name=itemInfo]').val();
    $.ajax({
        url: '/search-products',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify({
          'item': item,
        }),
        success: function(data) {
            searchData(data);
        }
    });
}

function itemEntry(t) {
    var id = t.lastChild.value;
    $.ajax({
        url: '/item',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify({
            'id': id
        }),
    success: function(data) {
        console.log(data.product);
        $('#searchResults').remove();
        var div = document.createElement('div');
        div.setAttribute('class', 'col-md-3');

        var input = document.createElement('input');
        input.setAttribute('type', 'text');
        input.setAttribute('name', 'input');
        input.setAttribute('readonly', true);
        input.setAttribute('id', 'code');
        input.setAttribute('class', 'form-control');
        input.setAttribute('value', data.product.itemCode);

        var label = document.createElement('label');
        label.setAttribute('for', 'input');
        label.innerHTML = 'Item Code';

        div.append(label);
        div.append(input);

        var div1 = document.createElement('div');
        div1.setAttribute('class', 'col-md-3');

        var input1 = document.createElement('input');
        input1.setAttribute('type', 'text');
        input1.setAttribute('name', 'input1');
        input1.setAttribute('readonly', true);
        input1.setAttribute('id', 'theName');
        input1.setAttribute('class', 'form-control');
        input1.setAttribute('value', data.product.name);

        var label1 = document.createElement('label');
        label1.setAttribute('for', 'input1');
        label1.innerHTML = 'Item Name';

        div1.append(label1);
        div1.append(input1);

        var div2 = document.createElement('div');
        div2.setAttribute('class', 'col-md-3');

        var input2 = document.createElement('input');
        input2.setAttribute('type', 'text');
        input2.setAttribute('name', 'input2');
        input2.setAttribute('readonly', true);
        input2.setAttribute('class', 'form-control');
        input2.setAttribute('value', data.product.quantity);

        var label2 = document.createElement('label');
        label2.setAttribute('for', 'input2');
        label2.innerHTML = 'Quantity';

        div2.append(label2);
        div2.append(input2);

        var div3 = document.createElement('div');
        div3.setAttribute('class', 'col-md-3');

        var input3 = document.createElement('input');
        input3.setAttribute('type', 'text');
        input3.setAttribute('name', 'input3');
        input3.setAttribute('readonly', true);
        input3.setAttribute('id', 'theSize');
        input3.setAttribute('class', 'form-control');
        input3.setAttribute('value', data.product.caseSize);

        var label3 = document.createElement('label');
        label3.setAttribute('for', 'input3');
        label3.innerHTML = 'U/M';

        div3.append(label3);
        div3.append(input3);

        var div4 = document.createElement('div');
        div4.setAttribute('class', 'col-md-3');

        var input4 = document.createElement('input');
        input4.setAttribute('type', 'text');
        input4.setAttribute('name', 'input4');
        input4.setAttribute('readonly', true);
        input4.setAttribute('id', 'theFrontPrice');
        input4.setAttribute('class', 'form-control');
        input4.setAttribute('value', data.product.frontPrice);

        var label4 = document.createElement('label');
        label4.setAttribute('for', 'input4');
        label4.innerHTML = 'Front Price';

        div4.append(label4);
        div4.append(input4);

        var div5 = document.createElement('div');
        div5.setAttribute('class', 'col-md-3');

        var input5 = document.createElement('input');
        input5.setAttribute('type', 'text');
        input5.setAttribute('name', 'input5');
        input5.setAttribute('readonly', true);
        input5.setAttribute('id', 'theTenPrice');
        input5.setAttribute('class', 'form-control');
        input5.setAttribute('value', data.product.tenCasePrice);

        var label5 = document.createElement('label');
        label5.setAttribute('for', 'input5');
        label5.innerHTML = '10 Case Price';

        div5.append(label5);
        div5.append(input5);

        var div6 = document.createElement('div');
        div6.setAttribute('class', 'col-md-3');

        var input6 = document.createElement('input');
        input6.setAttribute('type', 'text');
        input6.setAttribute('name', 'input6');
        input6.setAttribute('readonly', true);
        input6.setAttribute('id', 'theTwentyFivePrice');
        input6.setAttribute('class', 'form-control');
        input6.setAttribute('value', data.product.twentyFiveCasePrice);

        var label6 = document.createElement('label');
        label6.setAttribute('for', 'input6');
        label6.innerHTML = '25 Case Price';

        div6.append(label6);
        div6.append(input6);

        var row = document.createElement('div');
        row.setAttribute('class', 'col-md-12');
        row.setAttribute('id', 'theItem');

        row.append(div);
        row.append(div1);
        row.append(div2);
        row.append(div3);
        row.append(div4);
        row.append(div5);
        row.append(div6);

        var theDiv = document.createElement('div');
        theDiv.setAttribute('class', 'col-md-12');
        theDiv.append(row);

        $('#myContainer').append(theDiv)
        addItem();
        }
    });
}

function addItem() {
    var row = document.createElement('div');
    row.setAttribute('class', 'col-md-12');
    row.setAttribute('id', 'itemRow');

    var div = document.createElement('div');
    div.setAttribute('class', 'col-md-4');

    var input = document.createElement('input');
    input.setAttribute('type', 'number');
    input.setAttribute('name', 'input');
    input.setAttribute('class', 'form-control');
    input.setAttribute('id', 'theQuantity');
    input.setAttribute('placeholder', 'Enter Quantity')

    var label = document.createElement('label');
    label.setAttribute('for', 'input');
    label.innerHTML = 'Quantity';

    div.appendChild(label);
    div.appendChild(input);

    var div1 = document.createElement('div');
    div1.setAttribute('class', 'col-md-4');

    var input1 = document.createElement('input');
    input1.setAttribute('type', 'number');
    input1.setAttribute('name', 'input1');
    input1.setAttribute('id', 'thePrice');
    input1.setAttribute('class', 'form-control');
    input1.setAttribute('placeholder', 'Enter Price')

    var label1 = document.createElement('label');
    label1.setAttribute('for', 'input');
    label1.innerHTML = 'Price';

    div1.appendChild(label1);
    div1.appendChild(input1);

    var div2 = document.createElement('div');
    div2.setAttribute('class', 'col-md-4');

    var btn = document.createElement('button');
    btn.setAttribute('class', 'btn btn-primary');
    btn.setAttribute('id', 'orderBtn');
    btn.setAttribute('onclick', 'itemRow()');
    btn.innerHTML = "Add Item";

    div2.appendChild(btn);

    row.append(div);
    row.append(div1);
    row.append(div2);

    $('#myContainer').append(row);

    var tableForm = document.createElement('form');
    tableForm.setAttribute('id', 'tableForm');

    var theTable = document.createElement('table');
    theTable.setAttribute('class', 'dynatable table table-fixed-header table-bordered table-hover table-responsive table-striped overflow-y:hidden');
    theTable.setAttribute('id', 'orderItems');
    var headerRow = document.createElement('thead');
    headerRow.setAttribute('id', 'orderHeaders');

    var th = document.createElement('th');
    th.innerHTML = "Item Code";
    var th1 = document.createElement('th');
    th1.innerHTML = "Item Name";
    var th2 = document.createElement('th');
    th2.innerHTML = "Quantity";
    var th3 = document.createElement('th');
    th3.innerHTML = "U/M";
    var th4 = document.createElement('th');
    th4.innerHTML = "Price";
    var th5 = document.createElement('th');
    th5.innerHTML = "Delete";
    var th6 = document.createElement('th');
    th6.innerHTML = "amount";

    headerRow.appendChild(th);
    headerRow.appendChild(th1);
    headerRow.appendChild(th2);
    headerRow.appendChild(th3);
    headerRow.appendChild(th4);
    headerRow.appendChild(th6);
    headerRow.appendChild(th5);

    theTable.append(headerRow);

    var addItemBtn = document.createElement('button');
    addItemBtn.setAttribute('class', 'btn btn-primary');
    addItemBtn.setAttribute('id', 'theItemButton');
    addItemBtn.setAttribute('type', 'Submit');
    addItemBtn.setAttribute('onclick', 'addOrder(event)');
    addItemBtn.innerHTML = "Submit Order";

    tableForm.appendChild(theTable);
    tableForm.append(addItemBtn);

    // $('#myContainer').append(theTable);
    $('#myContainer').append(tableForm);
    // $('#myContainer').append(addItemBtn);
}

function itemRow() {
    var table = $('#orderItems');
    var code = $('#code').val();
    var name = $('#theName').val();
    var um = $('#theSize').val();
    var quantity = $('#theQuantity').val();
    var price = $('#thePrice').val();
    var delBtn = document.createElement('button');
    delBtn.setAttribute('class', 'btn btn-danger');
    delBtn.setAttribute('onclick', 'deleteRow(this)');
    delBtn.innerHTML = "Delete Item";

    var col = document.createElement('td');
    var input = document.createElement('input');
    input.setAttribute('value', code);
    input.setAttribute('type', 'hidden');
    input.setAttribute('name', 'code');
    col.append(input);
    col.innerHTML = code;

    var col1 = document.createElement('td');
    var input1 = document.createElement('input');
    input1.setAttribute('value', name);
    input1.setAttribute('type', 'hidden');
    input1.setAttribute('name', 'name');
    col1.innerHTML = name;

    var col2 = document.createElement('td');
    var input2 = document.createElement('input');
    input2.setAttribute('value', quantity);
    input2.setAttribute('type', 'hidden');
    input2.setAttribute('name', 'quantity');
    col2.append(input2);
    col2.innerHTML = quantity;

    var col3 = document.createElement('td');
    var input3 = document.createElement('input');
    input3.setAttribute('value', um);
    input3.setAttribute('type', 'hidden');
    input3.setAttribute('name', 'um');
    col3.append(input3);
    col3.innerHTML = um;

    var col4 = document.createElement('td');
    var input4 = document.createElement('input');
    input4.setAttribute('value', price);
    input4.setAttribute('type', 'hidden');
    input4.setAttribute('name', 'price');
    col4.append(input4);
    col4.innerHTML = price;

    var col5 = document.createElement('td');
    var input5 = document.createElement('input');
    input5.setAttribute('value', (price * quantity));
    input5.setAttribute('type', 'hidden');
    input5.setAttribute('name', 'amount');
    col5.append(input5);
    col5.innerHTML = (price * quantity);

    var col6 = document.createElement('td');
    col6.append(delBtn);

    var row = document.createElement('tr');

    row.appendChild(col);
    row.appendChild(col1);
    row.appendChild(col2);
    row.appendChild(col3);
    row.appendChild(col4);
    row.appendChild(col5);
    row.appendChild(col6);

    table.append(row);
}

function addOrder(event) {
    event.preventDefault();

    var data = [];

    var rows = document.getElementsByTagName('tr');
    for (var i = 0; i < rows.length; i++) {
        var cells = rows[i].children;
        var output = {};
        output.itemCode = cells[0].innerHTML;
        output.name = cells[1].innerHTML;
        output.quantity = cells[2].innerHTML;
        output.caseSize = cells[3].innerHTML;
        output.price = cells[4].innerHTML;
        output.amount = cells[5].innerHTML;
        data.push(output);
    }
    $.ajax({
        url: 'add-order',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify({
            'items': data
        }),
        success: function(data) {
            console.log(data);
        }
    });

}

function deleteRow(t) {
    t.parentNode.parentNode.remove();
}

function fleetView(event) {
    event.preventDefault();

    var header = $('#headerDiv');
    header.empty();

    var zeHeader = document.createElement('h1');
    zeHeader.setAttribute('id', 'myHeader');
    zeHeader.innerHTML = 'Vehicle Search';

    header.append(zeHeader);

    var row = $('#myContainer');
    if (row != null) {
        row.empty();
    }

    $('#myHeader').innerHTML = "Fleet Management";


    var div1 = document.createElement('div');
    div1.setAttribute('class', 'col-md-4');

    var div2 = document.createElement('div');
    div2.setAttribute('class', 'col-md-4');

    var div3 = document.createElement('div');
    div3.setAttribute('class', 'col-md-4');

    var fleetForm = document.createElement('form');
    fleetForm.setAttribute('id', 'fleetForm');
    fleetForm.setAttribute('class', 'form-inline');

    var input = document.createElement('input');
    input.setAttribute('type', 'text');
    input.setAttribute('class', 'form-control');
    input.setAttribute('name', 'fleetMake');
    input.setAttribute('placeholder', 'Search Vehicles');
    input.setAttribute('id', 'vehicleMake');

    var label = document.createElement('label');
    label.setAttribute('for', 'fleetMake');
    label.innerHTML = "Search vehicles by make";

    var btn = document.createElement('button');
    btn.setAttribute('class', 'btn btn-primary');
    btn.setAttribute('id', 'vehicleBtn');
    btn.setAttribute('type', 'submit');
    btn.setAttribute('onclick', 'searchVehicleMakes(event)');
    btn.innerHTML = "Submit";

    div1.appendChild(label);
    div2.appendChild(input);
    div3.appendChild(btn);

    fleetForm.appendChild(div1);
    fleetForm.appendChild(div2);
    fleetForm.appendChild(div3);

    row.append(fleetForm);
}

function searchVehicleMakes() {
    event.preventDefault();

    var table = $('#accountResults');
    if (table != null) {
        table.empty();
    }

    var f = $('#fleetForm');
    var make = f.find('[name=fleetMake]').val();

    var url = 'https://vpic.nhtsa.dot.gov/api/vehicles/getmodelsformakeyear/make/' + make + '/vehicleType/truck?format=json'

    $.get(url, function(data) {
        console.log(data);
        var theData = data.Results;
        console.log(theData);

        var myLabels = ['Make', 'Model', 'Vehicle Type'];

        var theTable = document.createElement('table');
        theTable.setAttribute('class', 'table table-bordered table-striped');
        theTable.setAttribute('id', 'accountResults');

        var headerRow = document.createElement('tr');
        headerRow.setAttribute('id', 'acctHeaders');

        for (var i = 0; i < myLabels.length; i++) {
            var headerCol = document.createElement('th');
            headerCol.innerHTML = myLabels[i];
            theTable.appendChild(headerCol);
        }
        var body = document.createElement('tbody');

        for (var l = 0; l < theData.length; l++) {
            var tableRow = document.createElement('tr');
            tableRow.setAttribute('ondblclick', 'vehicleInfo(event, this)');

            var col = document.createElement('td');
            col.innerHTML = theData[l].Make_Name;

            var col2 = document.createElement('td');
            col2.innerHTML = theData[l].Model_Name;

            var col3 = document.createElement('td');
            col3.innerHTML = theData[l].VehicleTypeName;

            tableRow.appendChild(col);
            tableRow.appendChild(col2);
            tableRow.appendChild(col3);

            body.appendChild(tableRow);
        }
        theTable.appendChild(body);
        $('#myContainer').append(theTable);
    });
}

function vehicleInfo(event, t) {
    event.preventDefault();
    var row = t;
    var cols = row.children;
    console.log(cols);

    var make = cols[0].innerHTML;
    var model = cols[1].innerHTML;
    var type = cols[2].innerHTML;

    console.log(make);
    console.log(model);
    console.log(type);

    var row = $('#myContainer');
    if (row != null) {
        row.empty();
    }

    var vehicleForm = document.createElement('form');
    vehicleForm.setAttribute('id', 'vehicleForm');

    var div = document.createElement('div');
    div.setAttribute('class', 'col-md-4');

    var label = document.createElement('label');
    label.setAttribute('for', 'make');
    label.innerHTML = 'Vehicle Make';

    var input = document.createElement('input');
    input.setAttribute('readonly', 'true');
    input.setAttribute('name', 'make');
    input.setAttribute('class', 'form-control');
    input.setAttribute('value', make);

    div.appendChild(label);
    div.appendChild(input);
    vehicleForm.appendChild(div);

    var div2 = document.createElement('div');
    div2.setAttribute('class', 'col-md-4');

    var label2 = document.createElement('label');
    label2.setAttribute('for', 'model');
    label2.innerHTML = 'Vehicle Model';

    var input2 = document.createElement('input');
    input2.setAttribute('readonly', 'true');
    input2.setAttribute('class', 'form-control');
    input2.setAttribute('name', 'model');
    input2.setAttribute('value', model);

    div2.appendChild(label2);
    div2.appendChild(input2);
    vehicleForm.appendChild(div2);

    var div3 = document.createElement('div');
    div3.setAttribute('class', 'col-md-4');

    var label3 = document.createElement('label');
    label3.setAttribute('for', 'type');
    label3.innerHTML = 'Vehicle Type';

    var input3 = document.createElement('input');
    input3.setAttribute('readonly', 'true');
    input3.setAttribute('class', 'form-control');
    input3.setAttribute('name', 'type');
    input3.setAttribute('value', type);

    div3.appendChild(label3);
    div3.appendChild(input3);
    vehicleForm.appendChild(div3);

    var div4 = document.createElement('div');
    div4.setAttribute('class', 'col-md-4');

    var label4 = document.createElement('label');
    label4.setAttribute('for', 'year');
    label4.innerHTML = 'Vehicle Year';

    var input4 = document.createElement('input');
    input4.setAttribute('name', 'year');
    input4.setAttribute('class', 'form-control');
    input4.setAttribute('type', 'number');

    div4.appendChild(label4);
    div4.appendChild(input4);
    vehicleForm.appendChild(div4);

    var div5 = document.createElement('div');
    div5.setAttribute('class', 'col-md-4');

    var label5 = document.createElement('label');
    label5.setAttribute('for', 'mileage');
    label5.innerHTML = 'Vehicle Mileage';

    var input5 = document.createElement('input');
    input5.setAttribute('name', 'mileage');
    input5.setAttribute('class', 'form-control');
    input5.setAttribute('type', 'number');

    div5.appendChild(label5);
    div5.appendChild(input5);
    vehicleForm.appendChild(div5);

    var div6 = document.createElement('div');
    div6.setAttribute('class', 'col-md-4');

    var input6 = document.createElement('input');
    input6.setAttribute('type', 'text');
    input6.setAttribute('class', 'form-control');
    input6.setAttribute('name', 'vin');

    var label6 = document.createElement('label');
    label6.setAttribute('for', 'vin');
    label6.innerHTML = 'Vehicle Vin';

    div6.appendChild(label6);
    div6.appendChild(input6);
    vehicleForm.appendChild(div6);

    var div7 = document.createElement('div');
    div7.setAttribute('class', 'col-md-4');

    var input7 = document.createElement('input');
    input7.setAttribute('type', 'text');
    input7.setAttribute('class', 'form-control');
    input7.setAttribute('name', 'plate');

    var label7 = document.createElement('label');
    label7.setAttribute('for', 'plate');
    label7.innerHTML = 'Vehicle License Plate';

    div7.appendChild(label7);
    div7.appendChild(input7);
    vehicleForm.appendChild(div7);

    var div8 = document.createElement('div');
    div8.setAttribute('class', 'col-md-4');

    var input8 = document.createElement('select');
    input8.setAttribute('class', 'form-control');
    input8.setAttribute('id', 'fuelType');
    input8.setAttribute('name', 'fueltype');

    var option = document.createElement('option');
    option.innerHTML = 'Gasoline';

    var option2 = document.createElement('option');
    option2.innerHTML = 'Diesel';

    var option3 = document.createElement('option');
    option3.innerHTML = 'Electric';

    var option4 = document.createElement('option');
    option4.innerHTML = 'Bio-Diesel';

    input8.appendChild(option);
    input8.appendChild(option2);
    input8.appendChild(option3);
    input8.appendChild(option4);

    var label8 = document.createElement('label');
    label8.setAttribute('for', 'fueltype');
    label8.innerHTML = 'Vehicle Fuel Type';

    div8.appendChild(label8);
    div8.appendChild(input8);
    vehicleForm.appendChild(div8);

    var div10 = document.createElement('div');
    div10.setAttribute('class', 'col-md-4');

    var input10 = document.createElement('input');
    input10.setAttribute('type', 'text');
    input10.setAttribute('class', 'form-control');
    input10.setAttribute('name', 'warrantyInfo');
    input10.setAttribute('id', 'warInformation');

    var label10 = document.createElement('label');
    label10.setAttribute('for', 'warrantyInfo');
    label10.setAttribute('id', 'warLabel');
    label10.innerHTML = 'Vehicle Warranty Info';

    div10.appendChild(label10);
    div10.appendChild(input10);
    vehicleForm.appendChild(div10);

    var div11 = document.createElement('div');
    div11.setAttribute('class', 'col-md-4');

    var vehicleBtn = document.createElement('button');
    vehicleBtn.setAttribute('class', 'btn btn-primary');
    vehicleBtn.setAttribute('id', 'vehicleBtn');
    vehicleBtn.setAttribute('onclick', 'addTruck(event)');
    vehicleBtn.innerHTML = 'Submit';

    div11.appendChild(vehicleBtn);
    vehicleForm.appendChild(div11);

    row.append(vehicleForm);
}

function addTruck(event) {
    event.preventDefault();
    var f = $('#vehicleForm');
    var make = f.find('[name=make]').val();
    var model = f.find('[name=model]').val();
    var type = f.find('[name=type]').val();
    var year = f.find('[name=year]').val();
    var mileage = f.find('[name=mileage]').val();
    var vin = f.find('[name=vin]').val();
    var plate = f.find('[name=plate]').val();
    var fueltype = f.find('[name=fueltype]').val();
    var warInfo = f.find('[name=warrantyInfo]').val();

    $.ajax({
        url: '/create-truck',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify({
            'make' : make,
            'model' : model,
            'type' : type,
            'year' : year,
            'mileage' : mileage,
            'vin' : vin,
            'plate' : plate,
            'fueltype' : fueltype,
            'warInfo' : warInfo
        }),
        success: function(data) {
            document.getElementById('vehicleForm').remove();
            fleetView(event);
        }
    });
}

function fleetDash(event) {
    event.preventDefault();

    var header = $('#headerDiv');
    header.empty();

    var zeHeader = document.createElement('h1');
    zeHeader.setAttribute('id', 'myHeader');
    zeHeader.innerHTML = 'Fleet Dashboard';

    header.append(zeHeader);

    var row = $('#myContainer');
    if (row != null) {
        row.empty();
    }

    var div = document.createElement('div');
    div.setAttribute('class', 'col-md-4');

    var div2 = document.createElement('div');
    div2.setAttribute('class', 'col-md-4');

    var div3 = document.createElement('div');
    div3.setAttribute('class', 'col-md-4');

    var label = document.createElement('label');
    label.setAttribute('for', 'fleet');
    label.innerHTML = 'Fleet List';

    var img = document.createElement('img');
    img.setAttribute('src', 'images/fleet.png');
    img.setAttribute('name', 'fleet');
    img.setAttribute('id', 'fleetPic');

    div.appendChild(label);
    div.appendChild(img);

    var label2 = document.createElement('label');
    label2.setAttribute('for', 'gps');
    label2.innerHTML = 'Routing and Logistics';

    var img2 = document.createElement('img');
    img2.setAttribute('src', 'images/gps.png');
    img2.setAttribute('name', 'gps');
    img2.setAttribute('id', 'gpsPic');

    div2.appendChild(label2);
    div2.appendChild(img2);

    var label3 = document.createElement('label');
    label3.setAttribute('for', 'addTruck');
    label3.innerHTML = 'Add Truck To Fleet';

    var img3 = document.createElement('img');
    img3.setAttribute('src', 'images/truck.jpeg');
    img3.setAttribute('name', 'addTruck');
    img.setAttribute('onclick', 'fleetView(event)');
    img3.setAttribute('id', 'theTruck');

    div3.appendChild(label3);
    div3.appendChild(img3);

    row.append(div);
    row.append(div2);
    row.append(div3);
}

function getFleetInfo(event) {
    event.preventDefault();
    $.get('/all-fleet-info', function(data) {
        console.log(data);
    });
}
