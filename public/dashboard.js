function boxDisable(t) {
    t.value = true;
    console.log(t.value);
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
    div1.setAttribute('class', 'col-md-6');

    var div2 = document.createElement('div');
    div2.setAttribute('class', 'col-md-6');

    var searchForm = document.createElement('form');
    //searchForm.setAttribute('class', 'form-group');
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

    searchLabel.append(searchBar);

    searchForm.append(searchLabel);
    searchForm.append(searchBar);
    searchForm.append(searchBtn);

    row.append(searchForm);

    var createLabel = document.createElement('label');
    createLabel.setAttribute('class', 'btn btn-primary selector');
    createLabel.innerHTML = "Inventory Creation";

    var createBtn = document.createElement('input');
    createBtn.setAttribute('type', 'radio');
    createBtn.setAttribute('name', 'createBtn');
    createBtn.setAttribute('id', 'option4');
    createBtn.setAttribute('autocomplete', 'off');
    createBtn.setAttribute('onclick', 'wineView(event)');

    var searchTitle = document.createElement('label');
    searchTitle.setAttribute('class', 'btn btn-primary selector');
    searchTitle.innerHTML = "Inventory Search";

    var searchBtn = document.createElement('input');
    searchBtn.setAttribute('type', 'radio');
    searchBtn.setAttribute('name', 'searchBtn');
    searchBtn.setAttribute('id', 'option5');
    searchBtn.setAttribute('autocomplete', 'off');

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
    row.empty();

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
    wineBtn.setAttribute('onclick', 'wineView(event)');

    var beerLabel = document.createElement('label');
    beerLabel.setAttribute('class', 'btn btn-primary selector');
    beerLabel.innerHTML = "Beer";

    var beerBtn = document.createElement('input');
    beerBtn.setAttribute('type', 'radio');
    beerBtn.setAttribute('name', 'options');
    beerBtn.setAttribute('id', 'option2');
    beerBtn.setAttribute('autocomplete', 'off');
    beerBtn.setAttribute('onclick', 'beerView(event)');

    var liquorLabel = document.createElement('label');
    liquorLabel.setAttribute('class', 'btn btn-primary selector');
    liquorLabel.innerHTML = "Liquour";

    var liquorBtn = document.createElement('input');
    liquorBtn.setAttribute('type', 'radio');
    liquorBtn.setAttribute('name', 'options');
    liquorBtn.setAttribute('id', 'option3');
    liquorBtn.setAttribute('autocomplete', 'off');
    liquorBtn.setAttribute('onclick', 'liquorView(event)');

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

    var myForm = document.createElement('form');
    myForm.setAttribute('name', 'wineForm');
    myForm.setAttribute('id', 'theWineForm');

    row.append(myForm);

    createWineView();

    var wineButton = document.createElement('button');
    wineButton.setAttribute('type', 'submit');
    wineButton.setAttribute('class', 'btn btn-primary');
    wineButton.setAttribute('id', 'wine');
    wineButton.setAttribute('onclick', 'createWine(event)');
    wineButton.innerHTML = 'Submit';

    var lastDiv = document.createElement('div');
    lastDiv.setAttribute('class', 'col-md-2');
    lastDiv.append(wineButton);

    myForm.appendChild(lastDiv);
}

function createWineView() {

  var myForm = $('#theWineForm');
  $.get('/product-models', function(data) {
    for (var i = 0; i < data.length; i ++) {
      var dataDiv = document.createElement('div');
      theDiv.setAttribute('class', 'col-md-2');
      theDiv.setAttribute('id', 'parent' + i);

      var input = document.createElement('input');
      input.setAttribute('type', 'text');
      // input.setAttribute('name', data.k);
      input.setAttribute('class', 'form-control');
      input.setAttribute('id', 'input' + i);

      var label = document.createElement('label');
      label.setAttribute('for', 'input' + i);
      // label.innerHTML = data.k;

      dataDiv.append(label);
      dataDiv.append(input);
      myForm.append(dataDiv);
    }
  });
}
    
    // var theDiv1 = document.createElement('div');
    // theDiv1.setAttribute('class', 'col-md-2');
    // theDiv1.setAttribute('id', 'parent');
    //
    // var theDiv2 = document.createElement('div');
    // theDiv2.setAttribute('class', 'col-md-2');
    // theDiv2.setAttribute('id', 'parent1');
    //
    // var theDiv3 = document.createElement('div');
    // theDiv3.setAttribute('class', 'col-md-2');
    // theDiv3.setAttribute('id', 'parent2');
    //
    // var theDiv4 = document.createElement('div');
    // theDiv4.setAttribute('class', 'col-md-2');
    // theDiv4.setAttribute('id', 'parent3');
    //
    // var theDiv5 = document.createElement('div');
    // theDiv5.setAttribute('class', 'col-md-2');
    // theDiv5.setAttribute('id', 'parent4');
    //
    // var theDiv6 = document.createElement('div');
    // theDiv6.setAttribute('class', 'col-md-2');
    // theDiv6.setAttribute('id', 'parent5');
    //
    // var theDiv7 = document.createElement('div');
    // theDiv7.setAttribute('class', 'col-md-2');
    // theDiv7.setAttribute('id', 'parent6');
    //
    // var theDiv8 = document.createElement('div');
    // theDiv8.setAttribute('class', 'col-md-2');
    // theDiv8.setAttribute('id', 'parent7');
    //
    // var theDiv9 = document.createElement('div');
    // theDiv9.setAttribute('class', ' col-md-2');
    // theDiv9.setAttribute('id', 'parent8');
    //
    // var theDiv10 = document.createElement('div');
    // theDiv10.setAttribute('class', ' col-md-2');
    // theDiv10.setAttribute('id', 'parent9');
    //
    // var theDiv11 = document.createElement('div');
    // theDiv11.setAttribute('class', ' col-md-2');
    // theDiv11.setAttribute('id', 'parent10');
    //
    // var theDiv12 = document.createElement('div');
    // theDiv12.setAttribute('class', ' col-md-2');
    // theDiv12.setAttribute('id', 'parent11');
    //
    // var theDiv13 = document.createElement('div');
    // theDiv13.setAttribute('class', ' col-md-2');
    // theDiv13.setAttribute('id', 'parent12');
    //
    // var theDiv14 = document.createElement('div');
    // theDiv14.setAttribute('class', ' col-md-2');
    // theDiv14.setAttribute('id', 'parent13');
    //
    // var theDiv15 = document.createElement('div');
    // theDiv15.setAttribute('class', ' col-md-2');
    // theDiv15.setAttribute('id', 'parent14');
    //
    // var theDiv16 = document.createElement('div');
    // theDiv16.setAttribute('class', ' col-md-2');
    // theDiv16.setAttribute('id', 'parent15');
    //
    // var theDiv17 = document.createElement('div');
    // theDiv17.setAttribute('class', ' col-md-2');
    // theDiv17.setAttribute('id', 'parent16');
    //
    // var theDiv18 = document.createElement('div');
    // theDiv18.setAttribute('class', ' col-md-2');
    // theDiv18.setAttribute('id', 'parent17');
    //
    // var theDiv19 = document.createElement('div');
    // theDiv19.setAttribute('class', ' col-md-2');
    // theDiv19.setAttribute('id', 'parent18');
    //
    // var theDiv20 = document.createElement('div');
    // theDiv20.setAttribute('class', ' col-md-2');
    // theDiv20.setAttribute('id', 'parent19');
    //
    // var theDiv21 = document.createElement('div');
    // theDiv21.setAttribute('class', ' col-md-2');
    // theDiv21.setAttribute('id', 'parent20');
    //
    // var theDiv22 = document.createElement('div');
    // theDiv22.setAttribute('class', ' col-md-2');
    // theDiv22.setAttribute('id', 'parent21');
    //
    // var theDiv23 = document.createElement('div');
    // theDiv23.setAttribute('class', ' col-md-2');
    // theDiv23.setAttribute('id', 'parent22');
    //
    // var theDiv24 = document.createElement('div');
    // theDiv24.setAttribute('class', ' col-md-2');
    // theDiv24.setAttribute('id', 'parent23');
    //
    // var theDiv25 = document.createElement('div');
    // theDiv25.setAttribute('class', ' col-md-2');
    // theDiv25.setAttribute('id', 'parent24');
    //
    // var theDiv26 = document.createElement('div');
    // theDiv26.setAttribute('class', ' col-md-2');
    // theDiv26.setAttribute('id', 'parent25');
    //
    // var theDiv27 = document.createElement('div');
    // theDiv27.setAttribute('class', ' col-md-2');
    // theDiv27.setAttribute('id', 'parent26');
    //
    // var theDiv28 = document.createElement('div');
    // theDiv28.setAttribute('class', ' col-md-2');
    // theDiv28.setAttribute('id', 'parent27');
    //
    // var theDiv29 = document.createElement('div');
    // theDiv29.setAttribute('class', ' col-md-2');
    // theDiv29.setAttribute('id', 'parent28');

    // var theDiv30 = document.createElement('div');
    // theDiv30.setAttribute('class', 'col-md-1');
    // theDiv30.setAttribute('id', 'popup1');
    // theDiv30.innerHTML = 'Enter product vintage';
    //
    // var theDiv31 = document.createElement('div');
    // theDiv31.setAttribute('class', ' col-md-1');
    // theDiv31.setAttribute('id', 'popup2');
    // theDiv31.innerHTML = 'Enter product varietal';
    //
    // var theDiv32 = document.createElement('div');
    // theDiv32.setAttribute('class', ' col-md-1');
    // theDiv32.setAttribute('id', 'popup3');
    // theDiv32.innerHTML = 'Enter product color';
    //
    // var theDiv33 = document.createElement('div');
    // theDiv33.setAttribute('class', ' col-md-1');
    // theDiv33.setAttribute('id', 'popup4');
    // theDiv33.innerHTML = 'Enter product importer';
    //
    // var theDiv34 = document.createElement('div');
    // theDiv34.setAttribute('class', ' col-md-1');
    // theDiv34.setAttribute('id', 'popup5');
    // theDiv34.innerHTML = 'Enter product name';
    //
    // var theDiv35 = document.createElement('div');
    // theDiv35.setAttribute('class', ' col-md-1');
    // theDiv35.setAttribute('id', 'popup6');
    // theDiv35.innerHTML = 'Enter product description';
    //
    // var theDiv36 = document.createElement('div');
    // theDiv36.setAttribute('class', ' col-md-1');
    // theDiv36.setAttribute('id', 'popup7');
    // theDiv36.innerHTML = 'Enter product item code';
    //
    // var theDiv37 = document.createElement('div');
    // theDiv37.setAttribute('class', ' col-md-1');
    // theDiv37.setAttribute('id', 'popup8');
    // theDiv37.innerHTML = 'Enter product origin';
    //
    // var theDiv38 = document.createElement('div');
    // theDiv38.setAttribute('class', ' col-md-1');
    // theDiv38.setAttribute('id', 'popup9');
    // theDiv38.innerHTML = 'Enter product volume';
    //
    // var theDiv39 = document.createElement('div');
    // theDiv39.setAttribute('class', ' col-md-1');
    // theDiv39.setAttribute('id', 'popup10');
    // theDiv39.innerHTML = 'Enter product front line price';
    //
    // var theDiv40 = document.createElement('div');
    // theDiv40.setAttribute('class', ' col-md-1');
    // theDiv40.setAttribute('id', 'popup11');
    // theDiv40.innerHTML = 'Enter product 10 case price';
    //
    // var theDiv41 = document.createElement('div');
    // theDiv41.setAttribute('class', ' col-md-1');
    // theDiv41.setAttribute('id', 'popup12');
    // theDiv41.innerHTML = 'Enter product 25 case price';
    //
    // var theDiv42 = document.createElement('div');
    // theDiv42.setAttribute('class', ' col-md-1');
    // theDiv42.setAttribute('id', 'popup13');
    // theDiv42.innerHTML = 'Enter product cost';
    //
    // var theDiv43 = document.createElement('div');
    // theDiv43.setAttribute('class', ' col-md-1');
    // theDiv43.setAttribute('id', 'popup14');
    // theDiv43.innerHTML = 'Enter product weight by bottle';
    //
    // var theDiv44 = document.createElement('div');
    // theDiv44.setAttribute('class', ' col-md-1');
    // theDiv44.setAttribute('id', 'popup15');
    // theDiv44.innerHTML = 'Enter product weight by case';
    //
    // var theDiv45 = document.createElement('div');
    // theDiv45.setAttribute('class', ' col-md-1');
    // theDiv45.setAttribute('id', 'popup16');
    // theDiv45.innerHTML = 'Enter product quantity';
    //
    // var theDiv46 = document.createElement('div');
    // theDiv46.setAttribute('class', ' col-md-1');
    // theDiv46.setAttribute('id', 'popup17');
    // theDiv46.innerHTML = 'Check if product is promised to a customer';
    //
    // var theDiv47 = document.createElement('div');
    // theDiv47.setAttribute('class', ' col-md-1');
    // theDiv47.setAttribute('id', 'popup18');
    // theDiv47.innerHTML = 'Check if product is able to be sold in both states';
    //
    // var theDiv48 = document.createElement('div');
    // theDiv48.setAttribute('class', ' col-md-1');
    // theDiv48.setAttribute('id', 'popup19');
    // theDiv48.innerHTML = 'Check if product comes in 1 pack cases';
    //
    // var theDiv49 = document.createElement('div');
    // theDiv49.setAttribute('class', ' col-md-1');
    // theDiv49.setAttribute('id', 'popup20');
    // theDiv49.innerHTML = 'Check if product comes in 3 pack cases';
    //
    // var theDiv50 = document.createElement('div');
    // theDiv50.setAttribute('class', ' col-md-1');
    // theDiv50.setAttribute('id', 'popup21');
    // theDiv50.innerHTML = 'Check if product comes in 6 pack cases';
    //
    // var theDiv51 = document.createElement('div');
    // theDiv51.setAttribute('class', ' col-md-1');
    // theDiv51.setAttribute('id', 'popup22');
    // theDiv51.innerHTML = 'Check if product comes in 9 pack cases';
    //
    // var theDiv52 = document.createElement('div');
    // theDiv52.setAttribute('class', ' col-md-1');
    // theDiv52.setAttribute('id', 'popup23');
    // theDiv52.innerHTML = 'Check if product comes in 12 pack cases';
    //
    // var theDiv53 = document.createElement('div');
    // theDiv53.setAttribute('class', ' col-md-1');
    // theDiv53.setAttribute('id', 'popup24');
    // theDiv53.innerHTML = 'Check if product comes in 24 pack cases';
    //
    // var theDiv54 = document.createElement('div');
    // theDiv54.setAttribute('class', ' col-md-1');
    // theDiv54.setAttribute('id', 'popup25');
    // theDiv54.innerHTML = 'Check if product comes in 5.17 gallon kegs';
    //
    // var theDiv55 = document.createElement('div');
    // theDiv55.setAttribute('class', ' col-md-1');
    // theDiv55.setAttribute('id', 'popup26');
    // theDiv55.innerHTML = 'Check if product comes in 7.75 gallon kegs';
    //
    // var theDiv56 = document.createElement('div');
    // theDiv56.setAttribute('class', ' col-md-1');
    // theDiv56.setAttribute('id', 'popup27');
    // theDiv56.innerHTML = 'Check if product comes in 15.5 gallon kegs';
    //
    // var theDiv57 = document.createElement('div');
    // theDiv57.setAttribute('class', ' col-md-1');
    // theDiv57.setAttribute('id', 'popup28');
    // theDiv57.innerHTML = 'Check if product comes in 20L kegs';
    //
    // var theDiv58 = document.createElement('div');
    // theDiv58.setAttribute('class', ' col-md-1');
    // theDiv58.setAttribute('id', 'popup29');
    // theDiv58.innerHTML = 'Check if product comes in 50L kegs';

    // var input1 = document.createElement('input');
    // input1.setAttribute('type', 'text');
    // input1.setAttribute('name', 'vintage');
    // input1.setAttribute('class', 'form-control');
    // input1.setAttribute('id', 'input1');
    //
    // var label1 = document.createElement('label');
    // label1.setAttribute('for', 'input1');
    // label1.innerHTML = "Vintage";
    //
    // theDiv1.append(label1);
    // theDiv1.append(input1);
    // theDiv1.append(theDiv30);
    //
    // var input2 = document.createElement('input');
    // input2.setAttribute('type', 'text');
    // input2.setAttribute('name', 'varietal');
    // input2.setAttribute('class', 'form-control');
    // input2.setAttribute('id', 'input2');
    //
    // var label2 = document.createElement('label');
    // label2.setAttribute('for', 'input2');
    // label2.innerHTML = 'Varietal';
    //
    // theDiv2.append(label2);
    // theDiv2.append(input2);
    // theDiv2.append(theDiv31);
    //
    // var input3 = document.createElement('input');
    // input3.setAttribute('type', 'text');
    // input3.setAttribute('name', 'color');
    // input3.setAttribute('class', 'form-control');
    // input3.setAttribute('id', 'input3');
    //
    // var label3 = document.createElement('label');
    // label3.setAttribute('for', 'input3');
    // label3.innerHTML = 'Color';
    //
    // theDiv3.append(label3);
    // theDiv3.append(input3);
    // theDiv3.append(theDiv32);
    //
    // var input4 = document.createElement('input');
    // input4.setAttribute('type', 'text');
    // input4.setAttribute('name', 'importer');
    // input4.setAttribute('class', 'form-control');
    // input4.setAttribute('id', 'input4');
    //
    // var label4 = document.createElement('label');
    // label4.setAttribute('for', 'input4');
    // label4.innerHTML = 'Importer';
    //
    // theDiv4.append(label4);
    // theDiv4.append(input4);
    // theDiv4.append(theDiv33);
    //
    // var input5 = document.createElement('input');
    // input5.setAttribute('type', 'text');
    // input5.setAttribute('name', 'name');
    // input5.setAttribute('class', 'form-control');
    // input5.setAttribute('id', 'input5');
    //
    // var label5 = document.createElement('label');
    // label5.setAttribute('for', 'input5');
    // label5.innerHTML = 'Name';
    //
    // theDiv5.append(label5);
    // theDiv5.append(input5);
    // theDiv5.append(theDiv34);
    //
    // var input6 = document.createElement('input');
    // input6.setAttribute('type', 'text');
    // input6.setAttribute('name', 'description');
    // input6.setAttribute('class', 'form-control');
    // input6.setAttribute('id', 'input6');
    //
    // var label6 = document.createElement('label');
    // label6.setAttribute('for', 'input6');
    // label6.innerHTML = 'Description';
    //
    // theDiv6.append(label6);
    // theDiv6.append(input6);
    // theDiv6.append(theDiv35);
    //
    // var input7 = document.createElement('input');
    // input7.setAttribute('type', 'text');
    // input7.setAttribute('name', 'itemCode');
    // input7.setAttribute('class', 'form-control');
    // input7.setAttribute('id', 'input7');
    //
    // var label7 = document.createElement('label');
    // label7.setAttribute('for', 'input7');
    // label7.innerHTML = 'Item Code';
    //
    // theDiv7.append(label7);
    // theDiv7.append(input7);
    // theDiv7.append(theDiv36);
    //
    // var input8 = document.createElement('input');
    // input8.setAttribute('type', 'text');
    // input8.setAttribute('name', 'origin');
    // input8.setAttribute('class', 'form-control');
    // input8.setAttribute('id', 'input8');
    //
    // var label8 = document.createElement('label');
    // label8.setAttribute('for', 'input8');
    // label8.innerHTML = 'Origin';
    //
    // theDiv8.append(label8);
    // theDiv8.append(input8);
    // theDiv8.append(theDiv37);
    //
    // var input9 = document.createElement('input');
    // input9.setAttribute('type', 'text');
    // input9.setAttribute('name', 'volume');
    // input9.setAttribute('class', 'form-control');
    // input9.setAttribute('id', 'input9');
    //
    // var label9 = document.createElement('label');
    // label9.setAttribute('for', 'input9');
    // label9.innerHTML = 'Volume';
    //
    // theDiv9.append(label9);
    // theDiv9.append(input9);
    // theDiv9.append(theDiv38);
    //
    // var input10 = document.createElement('input');
    // input10.setAttribute('type', 'text');
    // input10.setAttribute('name', 'frontPrice');
    // input10.setAttribute('class', 'form-control');
    // input10.setAttribute('id', 'input10');
    //
    // var label10 = document.createElement('label');
    // label10.setAttribute('for', 'input10');
    // label10.innerHTML = 'Front Price';
    //
    // theDiv10.append(label10);
    // theDiv10.append(input10);
    // theDiv10.append(theDiv39);
    //
    // var input11 = document.createElement('input');
    // input11.setAttribute('type', 'text');
    // input11.setAttribute('name', 'tenCasePrice');
    // input11.setAttribute('class', 'form-control');
    // input11.setAttribute('id', 'input11');
    //
    // var label11 = document.createElement('label');
    // label11.setAttribute('for', 'input11');
    // label11.innerHTML = '10 Case Price';
    //
    // theDiv11.append(label11);
    // theDiv11.append(input11);
    // theDiv11.append(theDiv40);
    //
    // var input12 = document.createElement('input');
    // input12.setAttribute('type', 'text');
    // input12.setAttribute('name', 'twentyFiveCasePrice');
    // input12.setAttribute('class', 'form-control');
    // input12.setAttribute('id', 'input12');
    //
    // var label12 = document.createElement('label');
    // label12.setAttribute('for', 'input12');
    // label12.innerHTML = '25 Case Price';
    //
    // theDiv12.append(label12);
    // theDiv12.append(input12);
    // theDiv12.append(theDiv41);
    //
    // var input13 = document.createElement('input');
    // input13.setAttribute('type', 'text');
    // input13.setAttribute('name', 'cost');
    // input13.setAttribute('class', 'form-control');
    // input13.setAttribute('id', 'input13');
    //
    // var label13 = document.createElement('label');
    // label13.setAttribute('for', 'input13');
    // label13.innerHTML = 'Cost';
    //
    // theDiv13.append(label13);
    // theDiv13.append(input13);
    // theDiv13.append(theDiv42);
    //
    // var input14 = document.createElement('input');
    // input14.setAttribute('type', 'text');
    // input14.setAttribute('name', 'bottleWeight');
    // input14.setAttribute('class', 'form-control');
    // input14.setAttribute('id', 'input14');
    //
    // var label14 = document.createElement('label');
    // label14.setAttribute('for', 'input14');
    // label14.innerHTML = 'Bottle Weight';
    //
    // theDiv14.append(label14);
    // theDiv14.append(input14);
    // theDiv14.append(theDiv43);
    //
    // var input15 = document.createElement('input');
    // input15.setAttribute('type', 'text');
    // input15.setAttribute('name', 'caseWeight');
    // input15.setAttribute('class', 'form-control');
    // input15.setAttribute('id', 'input15');
    //
    // var label15 = document.createElement('label');
    // label15.setAttribute('for', 'input15');
    // label15.innerHTML = 'Case Weight';
    //
    // theDiv15.append(label15);
    // theDiv15.append(input15);
    // theDiv15.append(theDiv44);
    //
    // var input16 = document.createElement('input');
    // input16.setAttribute('type', 'text');
    // input16.setAttribute('name', 'quantity');
    // input16.setAttribute('class', 'form-control');
    // input16.setAttribute('id', 'input16');
    //
    // var label16 = document.createElement('label');
    // label16.setAttribute('for', 'input16');
    // label16.innerHTML = 'Quantity';
    //
    // theDiv16.append(label16);
    // theDiv16.append(input16);
    // theDiv16.append(theDiv45);
    //
    // var input17 = document.createElement('input');
    // input17.setAttribute('type', 'checkbox');
    // input17.setAttribute('name', 'isExclusive');
    // input17.setAttribute('class', 'form-control box');
    // input17.setAttribute('id', 'input17');
    // input17.setAttribute('onclick', 'boxDisable($(this));');
    //
    // var label17 = document.createElement('label');
    // label17.setAttribute('for', 'input17');
    // label17.innerHTML = 'Exclusive';
    //
    // theDiv17.append(label17);
    // theDiv17.append(input17);
    // theDiv17.append(theDiv46);
    //
    // var input18 = document.createElement('input');
    // input18.setAttribute('type', 'checkbox');
    // input18.setAttribute('name', 'isDualState');
    // input18.setAttribute('class', 'form-control box');
    // input18.setAttribute('id', 'input18');
    // input18.setAttribute('onclick', 'boxDisable(event)');
    //
    // var label18 = document.createElement('label');
    // label18.setAttribute('for', 'input18');
    // label18.innerHTML = 'Dual States';
    //
    // theDiv18.append(label18);
    // theDiv18.append(input18);
    // theDiv18.append(theDiv47);
    //
    // var input19 = document.createElement('input');
    // input19.setAttribute('type', 'radio');
    // input19.setAttribute('name', 'wineCaseSize');
    // input19.setAttribute('value', 'ONE_PACK');
    // input19.setAttribute('class', 'form-control box');
    // input19.setAttribute('id', 'input19');
    //
    // var label19 = document.createElement('label');
    // label19.setAttribute('for', 'input19');
    // label19.innerHTML = '1 Pack';
    //
    // theDiv19.append(label19);
    // theDiv19.append(input19);
    // theDiv19.append(theDiv48);
    //
    // var input20 = document.createElement('input');
    // input20.setAttribute('type', 'radio');
    // input20.setAttribute('name', 'wineCaseSize');
    // input20.setAttribute('value', 'THREE_PACK');
    // input20.setAttribute('class', 'form-control box');
    // input20.setAttribute('id', 'input20');
    //
    // var label20 = document.createElement('label');
    // label20.setAttribute('for', 'input20');
    // label20.innerHTML = '3 Pack';
    //
    // theDiv20.append(label20);
    // theDiv20.append(input20);
    // theDiv20.append(theDiv49);
    //
    // var input21 = document.createElement('input');
    // input21.setAttribute('type', 'radio');
    // input21.setAttribute('name', 'wineCaseSize');
    // input21.setAttribute('value', 'SIX_PACK');
    // input21.setAttribute('class', 'form-control box');
    // input21.setAttribute('id', 'input21');
    //
    // var label21 = document.createElement('label');
    // label21.setAttribute('for', 'input21');
    // label21.innerHTML = '6 Pack';
    //
    // theDiv21.append(label21);
    // theDiv21.append(input21);
    // theDiv21.append(theDiv50);
    //
    // var input22 = document.createElement('input');
    // input22.setAttribute('type', 'radio');
    // input22.setAttribute('name', 'wineCaseSize');
    // input22.setAttribute('value', 'NINE_PACK');
    // input22.setAttribute('class', 'form-control box');
    // input22.setAttribute('id', 'input22');
    //
    // var label22 = document.createElement('label');
    // label22.setAttribute('for', 'input22');
    // label22.innerHTML = '9 Pack';
    //
    // theDiv22.append(label22);
    // theDiv22.append(input22);
    // theDiv22.append(theDiv51);
    //
    // var input23 = document.createElement('input');
    // input23.setAttribute('type', 'radio');
    // input23.setAttribute('name', 'wineCaseSize');
    // input23.setAttribute('value', 'TWELVE_PACK');
    // input23.setAttribute('class', 'form-control box');
    // input23.setAttribute('id', 'input23');
    //
    // var label23 = document.createElement('label');
    // label23.setAttribute('for', 'input23');
    // label23.innerHTML = '12 Pack';
    //
    // theDiv23.append(label23);
    // theDiv23.append(input23);
    // theDiv23.append(theDiv52);
    //
    // var input24 = document.createElement('input');
    // input24.setAttribute('type', 'radio');
    // input24.setAttribute('name', 'wineCaseSize');
    // input24.setAttribute('value', 'TWENTY_FOUR_PACK');
    // input24.setAttribute('class', 'form-control box');
    // input24.setAttribute('id', 'input24');
    //
    // var label24 = document.createElement('label');
    // label24.setAttribute('for', 'input24');
    // label24.innerHTML = '24 Pack';
    //
    // theDiv24.append(label24);
    // theDiv24.append(input24);
    // theDiv24.append(theDiv53);
    //
    // var input25 = document.createElement('input');
    // input25.setAttribute('type', 'radio');
    // input25.setAttribute('name', 'wineCaseSize');
    // input25.setAttribute('value', 'FIVE_SEVENTEEN_GAL_KEG');
    // input25.setAttribute('class', 'form-control box');
    // input25.setAttribute('id', 'input25');
    //
    // var label25 = document.createElement('label');
    // label25.setAttribute('for', 'input25');
    // label25.innerHTML = '5.17 Gallon Keg';
    //
    // theDiv25.append(label25);
    // theDiv25.append(input25);
    // theDiv25.append(theDiv54);
    //
    // var input26 = document.createElement('input');
    // input26.setAttribute('type', 'radio');
    // input26.setAttribute('name', 'wineCaseSize');
    // input26.setAttribute('value', 'SEVEN_SEVEN_FIVE_GAL_KEG');
    // input26.setAttribute('class', 'form-control box');
    // input26.setAttribute('id', 'input26');
    //
    // var label26 = document.createElement('label');
    // label26.setAttribute('for', 'input26');
    // label26.innerHTML = '7.75 Gallon Keg';
    //
    // theDiv26.append(label26);
    // theDiv26.append(input26);
    // theDiv26.append(theDiv55);
    //
    // var input27 = document.createElement('input');
    // input27.setAttribute('type', 'radio');
    // input27.setAttribute('name', 'wineCaseSize');
    // input27.setAttribute('value', 'FIFTEEN_FIVE_GAL_KEG');
    // input27.setAttribute('class', 'form-control box');
    // input27.setAttribute('id', 'input27');
    //
    // var label27 = document.createElement('label');
    // label27.setAttribute('for', 'input27');
    // label27.innerHTML = '15.5 Gallon Keg';
    //
    // theDiv27.append(label27);
    // theDiv27.append(input27);
    // theDiv27.append(theDiv56);
    //
    // var input28 = document.createElement('input');
    // input28.setAttribute('type', 'radio');
    // input28.setAttribute('name', 'wineCaseSize');
    // input28.setAttribute('value', 'TWENTY_LITRE_KEG');
    // input28.setAttribute('class', 'form-control box');
    // input28.setAttribute('id', 'input28');
    //
    // var label28 = document.createElement('label');
    // label28.setAttribute('for', 'input28');
    // label28.innerHTML = '20L Keg';
    //
    // theDiv28.append(label28);
    // theDiv28.append(input28);
    // theDiv28.append(theDiv57);
    //
    // var input29 = document.createElement('input');
    // input29.setAttribute('type', 'radio');
    // input29.setAttribute('name', 'wineCaseSize');
    // input29.setAttribute('value', 'FIFTY_LITRE_KEG');
    // input29.setAttribute('class', 'form-control box');
    // input29.setAttribute('id', 'input29');
    //
    // var label29 = document.createElement('label');
    // label29.setAttribute('for', 'input29');
    // label29.innerHTML = '50L Keg';
    //
    // theDiv29.append(label29);
    // theDiv29.append(input29);
    // theDiv29.append(theDiv58);
    //
    // myForm.appendChild(theDiv1);
    // myForm.appendChild(theDiv2);
    // myForm.appendChild(theDiv3);
    // myForm.appendChild(theDiv4);
    // myForm.appendChild(theDiv5);
    // myForm.appendChild(theDiv6);
    // myForm.appendChild(theDiv7);
    // myForm.appendChild(theDiv8);
    // myForm.appendChild(theDiv9);
    // myForm.appendChild(theDiv10);
    // myForm.appendChild(theDiv11);
    // myForm.appendChild(theDiv12);
    // myForm.appendChild(theDiv13);
    // myForm.appendChild(theDiv14);
    // myForm.appendChild(theDiv15);
    // myForm.appendChild(theDiv16);
    // myForm.appendChild(theDiv17);
    // myForm.appendChild(theDiv18);
    // myForm.appendChild(theDiv19);
    // myForm.appendChild(theDiv20);
    // myForm.appendChild(theDiv21);
    // myForm.appendChild(theDiv22);
    // myForm.appendChild(theDiv23);
    // myForm.appendChild(theDiv24);
    // myForm.appendChild(theDiv25);
    // myForm.appendChild(theDiv26);
    // myForm.appendChild(theDiv27);
    // myForm.appendChild(theDiv28);
    // myForm.appendChild(theDiv29);

    // for (var i = 0; i < 30; i++) {
    //     var divTarget = $('#parent' + i);
    //     divTarget.onmouseover = function() {
    //         document.getElementById('popup' + i).style.display = 'block';
    //     }
    //     divTarget.onmouseout = function() {
    //         document.getElementById('popup' + i).style.visibility = 'hidden';
    //     }
    // }



function createWine(event) {
    event.preventDefault();

    var f = $('#theWineForm');
    var vin = f.find('[name=vintage]').val();
    var vari = f.find('[name=varietal]').val();
    var iColor = f.find('[name=color]').val();
    var imp = f.find('[name=importer]').val();
    var name = f.find('[name=name]').val();
    var desc = f.find('[name=description]').val();
    var itemC = f.find('[name=itemCode]').val();
    var orig = f.find('[name=origin]').val();
    var vol = f.find('[name=volume]').val();
    var frontP = f.find('[name=frontPrice]').val();
    var tenCP = f.find('[name=tenCasePrice]').val();
    var twentyFCP = f.find('[name=twentyFiveCasePrice]').val();
    var theCost = f.find('[name=cost]').val();
    var bottleW = f.find('[name=bottleWeight]').val();
    var caseW = f.find('[name=caseWeight]').val();
    var quantity = f.find('[name=quantity]').val();
    var wCS = $("#theWineForm input[type='radio']:checked").val();;
    var exclu;
    var dualS;
    if ($("#theWineForm input[id='input17']:checked").val() == 'on') {
        exclu = true;
    } else {
        exclu = false;
    }

    if ($("#theWineForm input[id='input18']:checked").val() == 'on') {
        dualS = true;
    } else {
        dualS = false;
    }

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

function beerView(Event) {
    event.preventDefault();
    var row = $('#myContainer');
    row.empty();

    var beerHeader = document.createElement('h1');
    beerHeader.setAttribute('id', 'beerHeader');
    beerHeader.innerHTML = "Beer Creation Sheet";

    row.append(beerHeader);

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
    wineBtn.setAttribute('onclick', 'wineView(event)');

    var beerLabel = document.createElement('label');
    beerLabel.setAttribute('class', 'btn btn-primary selector');
    beerLabel.innerHTML = "Beer";

    var beerBtn = document.createElement('input');
    beerBtn.setAttribute('type', 'radio');
    beerBtn.setAttribute('name', 'options');
    beerBtn.setAttribute('id', 'option2');
    beerBtn.setAttribute('autocomplete', 'off');
    beerBtn.setAttribute('onclick', 'beerView(event)');

    var liquorLabel = document.createElement('label');
    liquorLabel.setAttribute('class', 'btn btn-primary selector');
    liquorLabel.innerHTML = "Liquour";

    var liquorBtn = document.createElement('input');
    liquorBtn.setAttribute('type', 'radio');
    liquorBtn.setAttribute('name', 'options');
    liquorBtn.setAttribute('id', 'option3');
    liquorBtn.setAttribute('autocomplete', 'off');
    liquorBtn.setAttribute('onclick', 'liquorView(event)');

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

    var theDiv1 = document.createElement('div');
    theDiv1.setAttribute('class', 'col-md-2');
    theDiv1.setAttribute('id', 'parent');

    var theDiv2 = document.createElement('div');
    theDiv2.setAttribute('class', 'col-md-2');
    theDiv2.setAttribute('id', 'parent1');

    var theDiv3 = document.createElement('div');
    theDiv3.setAttribute('class', 'col-md-2');
    theDiv3.setAttribute('id', 'parent2');

    var theDiv4 = document.createElement('div');
    theDiv4.setAttribute('class', 'col-md-2');
    theDiv4.setAttribute('id', 'parent3');

    var theDiv5 = document.createElement('div');
    theDiv5.setAttribute('class', 'col-md-2');
    theDiv5.setAttribute('id', 'parent4');

    var theDiv6 = document.createElement('div');
    theDiv6.setAttribute('class', 'col-md-2');
    theDiv6.setAttribute('id', 'parent5');

    var theDiv7 = document.createElement('div');
    theDiv7.setAttribute('class', 'col-md-2');
    theDiv7.setAttribute('id', 'parent6');

    var theDiv8 = document.createElement('div');
    theDiv8.setAttribute('class', 'col-md-2');
    theDiv8.setAttribute('id', 'parent7');

    var theDiv9 = document.createElement('div');
    theDiv9.setAttribute('class', ' col-md-2');
    theDiv9.setAttribute('id', 'parent8');

    var theDiv10 = document.createElement('div');
    theDiv10.setAttribute('class', ' col-md-2');
    theDiv10.setAttribute('id', 'parent9');

    var theDiv11 = document.createElement('div');
    theDiv11.setAttribute('class', ' col-md-2');
    theDiv11.setAttribute('id', 'parent10');

    var theDiv12 = document.createElement('div');
    theDiv12.setAttribute('class', ' col-md-2');
    theDiv12.setAttribute('id', 'parent11');

    var theDiv13 = document.createElement('div');
    theDiv13.setAttribute('class', ' col-md-2');
    theDiv13.setAttribute('id', 'parent12');

    var theDiv14 = document.createElement('div');
    theDiv14.setAttribute('class', ' col-md-2');
    theDiv14.setAttribute('id', 'parent13');

    var theDiv15 = document.createElement('div');
    theDiv15.setAttribute('class', ' col-md-2');
    theDiv15.setAttribute('id', 'parent14');

    var theDiv16 = document.createElement('div');
    theDiv16.setAttribute('class', ' col-md-2');
    theDiv16.setAttribute('id', 'parent15');

    var theDiv17 = document.createElement('div');
    theDiv17.setAttribute('class', ' col-md-2');
    theDiv17.setAttribute('id', 'parent16');

    var theDiv18 = document.createElement('div');
    theDiv18.setAttribute('class', ' col-md-2');
    theDiv18.setAttribute('id', 'parent17');

    var theDiv19 = document.createElement('div');
    theDiv19.setAttribute('class', ' col-md-2');
    theDiv19.setAttribute('id', 'parent18');

    var theDiv20 = document.createElement('div');
    theDiv20.setAttribute('class', ' col-md-2');
    theDiv20.setAttribute('id', 'parent19');

    var theDiv21 = document.createElement('div');
    theDiv21.setAttribute('class', ' col-md-2');
    theDiv21.setAttribute('id', 'parent20');

    var theDiv22 = document.createElement('div');
    theDiv22.setAttribute('class', ' col-md-2');
    theDiv22.setAttribute('id', 'parent21');

    var theDiv23 = document.createElement('div');
    theDiv23.setAttribute('class', ' col-md-2');
    theDiv23.setAttribute('id', 'parent22');

    var theDiv24 = document.createElement('div');
    theDiv24.setAttribute('class', ' col-md-2');
    theDiv24.setAttribute('id', 'parent23');

    var theDiv25 = document.createElement('div');
    theDiv25.setAttribute('class', ' col-md-2');
    theDiv25.setAttribute('id', 'parent24');

    var theDiv26 = document.createElement('div');
    theDiv26.setAttribute('class', ' col-md-2');
    theDiv26.setAttribute('id', 'parent25');

    var theDiv27 = document.createElement('div');
    theDiv27.setAttribute('class', ' col-md-2');
    theDiv27.setAttribute('id', 'parent26');

    var theDiv28 = document.createElement('div');
    theDiv28.setAttribute('class', ' col-md-2');
    theDiv28.setAttribute('id', 'parent27');

    var theDiv29 = document.createElement('div');
    theDiv29.setAttribute('class', ' col-md-2');
    theDiv29.setAttribute('id', 'parent28');

    var theDiv30 = document.createElement('div');
    theDiv30.setAttribute('class', 'col-md-1');
    theDiv30.setAttribute('id', 'popup1');
    theDiv30.innerHTML = 'Enter product lot-date';

    var theDiv31 = document.createElement('div');
    theDiv31.setAttribute('class', ' col-md-1');
    theDiv31.setAttribute('id', 'popup2');
    theDiv31.innerHTML = 'Enter product expiration';

    var theDiv32 = document.createElement('div');
    theDiv32.setAttribute('class', ' col-md-1');
    theDiv32.setAttribute('id', 'popup3');
    theDiv32.innerHTML = 'Enter product beerType';

    var theDiv33 = document.createElement('div');
    theDiv33.setAttribute('class', ' col-md-1');
    theDiv33.setAttribute('id', 'popup4');
    theDiv33.innerHTML = 'Enter product brewery';

    var theDiv34 = document.createElement('div');
    theDiv34.setAttribute('class', ' col-md-1');
    theDiv34.setAttribute('id', 'popup5');
    theDiv34.innerHTML = 'Enter product name';

    var theDiv35 = document.createElement('div');
    theDiv35.setAttribute('class', ' col-md-1');
    theDiv35.setAttribute('id', 'popup6');
    theDiv35.innerHTML = 'Enter product description';

    var theDiv36 = document.createElement('div');
    theDiv36.setAttribute('class', ' col-md-1');
    theDiv36.setAttribute('id', 'popup7');
    theDiv36.innerHTML = 'Enter product item code';

    var theDiv37 = document.createElement('div');
    theDiv37.setAttribute('class', ' col-md-1');
    theDiv37.setAttribute('id', 'popup8');
    theDiv37.innerHTML = 'Enter product origin';

    var theDiv38 = document.createElement('div');
    theDiv38.setAttribute('class', ' col-md-1');
    theDiv38.setAttribute('id', 'popup9');
    theDiv38.innerHTML = 'Enter product volume';

    var theDiv39 = document.createElement('div');
    theDiv39.setAttribute('class', ' col-md-1');
    theDiv39.setAttribute('id', 'popup10');
    theDiv39.innerHTML = 'Enter product front line price';

    var theDiv40 = document.createElement('div');
    theDiv40.setAttribute('class', ' col-md-1');
    theDiv40.setAttribute('id', 'popup11');
    theDiv40.innerHTML = 'Enter product 10 case price';

    var theDiv41 = document.createElement('div');
    theDiv41.setAttribute('class', ' col-md-1');
    theDiv41.setAttribute('id', 'popup12');
    theDiv41.innerHTML = 'Enter product 25 case price';

    var theDiv42 = document.createElement('div');
    theDiv42.setAttribute('class', ' col-md-1');
    theDiv42.setAttribute('id', 'popup13');
    theDiv42.innerHTML = 'Enter product cost';

    var theDiv43 = document.createElement('div');
    theDiv43.setAttribute('class', ' col-md-1');
    theDiv43.setAttribute('id', 'popup14');
    theDiv43.innerHTML = 'Enter product weight by bottle';

    var theDiv44 = document.createElement('div');
    theDiv44.setAttribute('class', ' col-md-1');
    theDiv44.setAttribute('id', 'popup15');
    theDiv44.innerHTML = 'Enter product weight by case';

    var theDiv45 = document.createElement('div');
    theDiv45.setAttribute('class', ' col-md-1');
    theDiv45.setAttribute('id', 'popup16');
    theDiv45.innerHTML = 'Enter product quantity';

    var theDiv46 = document.createElement('div');
    theDiv46.setAttribute('class', ' col-md-1');
    theDiv46.setAttribute('id', 'popup17');
    theDiv46.innerHTML = 'Check if product is promised to a customer';

    var theDiv47 = document.createElement('div');
    theDiv47.setAttribute('class', ' col-md-1');
    theDiv47.setAttribute('id', 'popup18');
    theDiv47.innerHTML = 'Check if product is able to be sold in both states';

    var theDiv48 = document.createElement('div');
    theDiv48.setAttribute('class', ' col-md-1');
    theDiv48.setAttribute('id', 'popup19');
    theDiv48.innerHTML = 'Check if product comes in 1 pack cases';

    var theDiv49 = document.createElement('div');
    theDiv49.setAttribute('class', ' col-md-1');
    theDiv49.setAttribute('id', 'popup20');
    theDiv49.innerHTML = 'Check if product comes in 3 pack cases';

    var theDiv50 = document.createElement('div');
    theDiv50.setAttribute('class', ' col-md-1');
    theDiv50.setAttribute('id', 'popup21');
    theDiv50.innerHTML = 'Check if product comes in 6 pack cases';

    var theDiv51 = document.createElement('div');
    theDiv51.setAttribute('class', ' col-md-1');
    theDiv51.setAttribute('id', 'popup22');
    theDiv51.innerHTML = 'Check if product comes in 9 pack cases';

    var theDiv52 = document.createElement('div');
    theDiv52.setAttribute('class', ' col-md-1');
    theDiv52.setAttribute('id', 'popup23');
    theDiv52.innerHTML = 'Check if product comes in 12 pack cases';

    var theDiv53 = document.createElement('div');
    theDiv53.setAttribute('class', ' col-md-1');
    theDiv53.setAttribute('id', 'popup24');
    theDiv53.innerHTML = 'Check if product comes in 24 pack cases';

    var theDiv54 = document.createElement('div');
    theDiv54.setAttribute('class', ' col-md-1');
    theDiv54.setAttribute('id', 'popup25');
    theDiv54.innerHTML = 'Check if product comes in 5.17 gallon kegs';

    var theDiv55 = document.createElement('div');
    theDiv55.setAttribute('class', ' col-md-1');
    theDiv55.setAttribute('id', 'popup26');
    theDiv55.innerHTML = 'Check if product comes in 7.75 gallon kegs';

    var theDiv56 = document.createElement('div');
    theDiv56.setAttribute('class', ' col-md-1');
    theDiv56.setAttribute('id', 'popup27');
    theDiv56.innerHTML = 'Check if product comes in 15.5 gallon kegs';

    var theDiv57 = document.createElement('div');
    theDiv57.setAttribute('class', ' col-md-1');
    theDiv57.setAttribute('id', 'popup28');
    theDiv57.innerHTML = 'Check if product comes in 20L kegs';

    var theDiv58 = document.createElement('div');
    theDiv58.setAttribute('class', ' col-md-1');
    theDiv58.setAttribute('id', 'popup29');
    theDiv58.innerHTML = 'Check if product comes in 50L kegs';

    var myForm = document.createElement('form');
    myForm.setAttribute('name', 'beerForm');
    myForm.setAttribute('id', 'theBeerForm');

    var input1 = document.createElement('input');
    input1.setAttribute('type', 'date');
    input1.setAttribute('name', 'lotDate');
    input1.setAttribute('class', 'form-control');
    input1.setAttribute('id', 'input1');

    var label1 = document.createElement('label');
    label1.setAttribute('for', 'input1');
    label1.innerHTML = "Lot-date";

    theDiv1.append(label1);
    theDiv1.append(input1);
    theDiv1.append(theDiv30);

    var input2 = document.createElement('input');
    input2.setAttribute('type', 'date');
    input2.setAttribute('name', 'expirationDate');
    input2.setAttribute('class', 'form-control');
    input2.setAttribute('id', 'input2');

    var label2 = document.createElement('label');
    label2.setAttribute('for', 'input2');
    label2.innerHTML = 'Expiration-date';

    theDiv2.append(label2);
    theDiv2.append(input2);
    theDiv2.append(theDiv31);

    var input3 = document.createElement('input');
    input3.setAttribute('type', 'text');
    input3.setAttribute('name', 'beerType');
    input3.setAttribute('class', 'form-control');
    input3.setAttribute('id', 'input3');

    var label3 = document.createElement('label');
    label3.setAttribute('for', 'input3');
    label3.innerHTML = 'Beer type';

    theDiv3.append(label3);
    theDiv3.append(input3);
    theDiv3.append(theDiv32);

    var input4 = document.createElement('input');
    input4.setAttribute('type', 'text');
    input4.setAttribute('name', 'Brewery');
    input4.setAttribute('class', 'form-control');
    input4.setAttribute('id', 'input4');

    var label4 = document.createElement('label');
    label4.setAttribute('for', 'input4');
    label4.innerHTML = 'Brewery';

    theDiv4.append(label4);
    theDiv4.append(input4);
    theDiv4.append(theDiv33);

    var input5 = document.createElement('input');
    input5.setAttribute('type', 'text');
    input5.setAttribute('name', 'name');
    input5.setAttribute('class', 'form-control');
    input5.setAttribute('id', 'input5');

    var label5 = document.createElement('label');
    label5.setAttribute('for', 'input5');
    label5.innerHTML = 'Name';

    theDiv5.append(label5);
    theDiv5.append(input5);
    theDiv5.append(theDiv34);

    var input6 = document.createElement('input');
    input6.setAttribute('type', 'text');
    input6.setAttribute('name', 'description');
    input6.setAttribute('class', 'form-control');
    input6.setAttribute('id', 'input6');

    var label6 = document.createElement('label');
    label6.setAttribute('for', 'input6');
    label6.innerHTML = 'Description';

    theDiv6.append(label6);
    theDiv6.append(input6);
    theDiv6.append(theDiv35);

    var input7 = document.createElement('input');
    input7.setAttribute('type', 'text');
    input7.setAttribute('name', 'itemCode');
    input7.setAttribute('class', 'form-control');
    input7.setAttribute('id', 'input7');

    var label7 = document.createElement('label');
    label7.setAttribute('for', 'input7');
    label7.innerHTML = 'Item Code';

    theDiv7.append(label7);
    theDiv7.append(input7);
    theDiv7.append(theDiv36);

    var input8 = document.createElement('input');
    input8.setAttribute('type', 'text');
    input8.setAttribute('name', 'origin');
    input8.setAttribute('class', 'form-control');
    input8.setAttribute('id', 'input8');

    var label8 = document.createElement('label');
    label8.setAttribute('for', 'input8');
    label8.innerHTML = 'Origin';

    theDiv8.append(label8);
    theDiv8.append(input8);
    theDiv8.append(theDiv37);

    var input9 = document.createElement('input');
    input9.setAttribute('type', 'text');
    input9.setAttribute('name', 'volume');
    input9.setAttribute('class', 'form-control');
    input9.setAttribute('id', 'input9');

    var label9 = document.createElement('label');
    label9.setAttribute('for', 'input9');
    label9.innerHTML = 'Volume';

    theDiv9.append(label9);
    theDiv9.append(input9);
    theDiv9.append(theDiv38);

    var input10 = document.createElement('input');
    input10.setAttribute('type', 'text');
    input10.setAttribute('name', 'frontPrice');
    input10.setAttribute('class', 'form-control');
    input10.setAttribute('id', 'input10');

    var label10 = document.createElement('label');
    label10.setAttribute('for', 'input10');
    label10.innerHTML = 'Front Price';

    theDiv10.append(label10);
    theDiv10.append(input10);
    theDiv10.append(theDiv39);

    var input11 = document.createElement('input');
    input11.setAttribute('type', 'text');
    input11.setAttribute('name', 'tenCasePrice');
    input11.setAttribute('class', 'form-control');
    input11.setAttribute('id', 'input11');

    var label11 = document.createElement('label');
    label11.setAttribute('for', 'input11');
    label11.innerHTML = '10 Case Price';

    theDiv11.append(label11);
    theDiv11.append(input11);
    theDiv11.append(theDiv40);

    var input12 = document.createElement('input');
    input12.setAttribute('type', 'text');
    input12.setAttribute('name', 'twentyFiveCasePrice');
    input12.setAttribute('class', 'form-control');
    input12.setAttribute('id', 'input12');

    var label12 = document.createElement('label');
    label12.setAttribute('for', 'input12');
    label12.innerHTML = '25 Case Price';

    theDiv12.append(label12);
    theDiv12.append(input12);
    theDiv12.append(theDiv41);

    var input13 = document.createElement('input');
    input13.setAttribute('type', 'text');
    input13.setAttribute('name', 'cost');
    input13.setAttribute('class', 'form-control');
    input13.setAttribute('id', 'input13');

    var label13 = document.createElement('label');
    label13.setAttribute('for', 'input13');
    label13.innerHTML = 'Cost';

    theDiv13.append(label13);
    theDiv13.append(input13);
    theDiv13.append(theDiv42);

    var input14 = document.createElement('input');
    input14.setAttribute('type', 'text');
    input14.setAttribute('name', 'bottleWeight');
    input14.setAttribute('class', 'form-control');
    input14.setAttribute('id', 'input14');

    var label14 = document.createElement('label');
    label14.setAttribute('for', 'input14');
    label14.innerHTML = 'Bottle Weight';

    theDiv14.append(label14);
    theDiv14.append(input14);
    theDiv14.append(theDiv43);

    var input15 = document.createElement('input');
    input15.setAttribute('type', 'text');
    input15.setAttribute('name', 'caseWeight');
    input15.setAttribute('class', 'form-control');
    input15.setAttribute('id', 'input15');

    var label15 = document.createElement('label');
    label15.setAttribute('for', 'input15');
    label15.innerHTML = 'Case Weight';

    theDiv15.append(label15);
    theDiv15.append(input15);
    theDiv15.append(theDiv44);

    var input16 = document.createElement('input');
    input16.setAttribute('type', 'text');
    input16.setAttribute('name', 'quantity');
    input16.setAttribute('class', 'form-control');
    input16.setAttribute('id', 'input16');

    var label16 = document.createElement('label');
    label16.setAttribute('for', 'input16');
    label16.innerHTML = 'Quantity';

    theDiv16.append(label16);
    theDiv16.append(input16);
    theDiv16.append(theDiv45);

    var input17 = document.createElement('input');
    input17.setAttribute('type', 'checkbox');
    input17.setAttribute('name', 'isExclusive');
    input17.setAttribute('class', 'form-control box');
    input17.setAttribute('id', 'input17');
    input17.setAttribute('onclick', 'boxDisable($(this));');

    var label17 = document.createElement('label');
    label17.setAttribute('for', 'input17');
    label17.innerHTML = 'Exclusive';

    theDiv17.append(label17);
    theDiv17.append(input17);
    theDiv17.append(theDiv46);

    var input18 = document.createElement('input');
    input18.setAttribute('type', 'checkbox');
    input18.setAttribute('name', 'dualState');
    input18.setAttribute('class', 'form-control box');
    input18.setAttribute('id', 'input18');
    input18.setAttribute('onclick', 'boxDisable($(this));');

    var label18 = document.createElement('label');
    label18.setAttribute('for', 'input18');
    label18.innerHTML = 'Dual States';

    theDiv18.append(label18);
    theDiv18.append(input18);
    theDiv18.append(theDiv47);

    var domDiv = document.createElement('div');
    domDiv.setAttribute('class', 'col-md-2');
    domDiv.setAttribute('id', 'parent29');

    var domDiv2 = document.createElement('div');
    domDiv2.setAttribute('class', 'col-md-1');
    domDiv2.setAttribute('id', 'popup30');

    var domestic = document.createElement('input');
    domestic.setAttribute('type', 'checkbox');
    domestic.setAttribute('name', 'domes');
    domestic.setAttribute('class', 'form-control box');
    domestic.setAttribute('id', 'input30');
    domestic.setAttribute('onclick', 'boxDisable($(this));');

    var domesticLabel = document.createElement('label');
    domesticLabel.setAttribute('for', 'domestic');
    domesticLabel.innerHTML = "Domestic";

    domDiv.append(domesticLabel);
    domDiv.append(domestic);
    domDiv.append(domDiv2);

    var seaDiv = document.createElement('div');
    seaDiv.setAttribute('class', 'col-md-2');
    seaDiv.setAttribute('id', 'parent30');

    var seaDiv2 = document.createElement('div');
    seaDiv2.setAttribute('class', 'col-md-1');
    seaDiv2.setAttribute('id', 'popup31');

    var seasonal = document.createElement('input');
    seasonal.setAttribute('type', 'checkbox');
    seasonal.setAttribute('name', 'seasons');
    seasonal.setAttribute('class', 'form-control box');
    seasonal.setAttribute('id', 'input31');
    seasonal.setAttribute('onclick', 'boxDisable($(this));');

    var seaLabel = document.createElement('label');
    seaLabel.setAttribute('for', 'seasonal');
    seaLabel.innerHTML = "Seasonal";

    seaDiv.append(seaLabel);
    seaDiv.append(seasonal);
    seaDiv.append(seaDiv2);

    var input19 = document.createElement('input');
    input19.setAttribute('type', 'radio');
    input19.setAttribute('name', 'beerCaseSize');
    input19.setAttribute('value', 'ONE_PACK');
    input19.setAttribute('class', 'form-control box');
    input19.setAttribute('id', 'input19');

    var label19 = document.createElement('label');
    label19.setAttribute('for', 'input19');
    label19.innerHTML = '1 Pack';

    theDiv19.append(label19);
    theDiv19.append(input19);
    theDiv19.append(theDiv48);

    var input20 = document.createElement('input');
    input20.setAttribute('type', 'radio');
    input20.setAttribute('name', 'beerCaseSize');
    input20.setAttribute('value', 'THREE_PACK');
    input20.setAttribute('class', 'form-control box');
    input20.setAttribute('id', 'input20');

    var label20 = document.createElement('label');
    label20.setAttribute('for', 'input20');
    label20.innerHTML = '3 Pack';

    theDiv20.append(label20);
    theDiv20.append(input20);
    theDiv20.append(theDiv49);

    var input21 = document.createElement('input');
    input21.setAttribute('type', 'radio');
    input21.setAttribute('name', 'beerCaseSize');
    input21.setAttribute('value', 'SIX_PACK');
    input21.setAttribute('class', 'form-control box');
    input21.setAttribute('id', 'input21');

    var label21 = document.createElement('label');
    label21.setAttribute('for', 'input21');
    label21.innerHTML = '6 Pack';

    theDiv21.append(label21);
    theDiv21.append(input21);
    theDiv21.append(theDiv50);

    var input22 = document.createElement('input');
    input22.setAttribute('type', 'radio');
    input22.setAttribute('name', 'beerCaseSize');
    input22.setAttribute('value', 'NINE_PACK');
    input22.setAttribute('class', 'form-control box');
    input22.setAttribute('id', 'input22');

    var label22 = document.createElement('label');
    label22.setAttribute('for', 'input22');
    label22.innerHTML = '9 Pack';

    theDiv22.append(label22);
    theDiv22.append(input22);
    theDiv22.append(theDiv51);

    var input23 = document.createElement('input');
    input23.setAttribute('type', 'radio');
    input23.setAttribute('name', 'beerCaseSize');
    input23.setAttribute('value', 'TWELVE_PACK');
    input23.setAttribute('class', 'form-control box');
    input23.setAttribute('id', 'input23');

    var label23 = document.createElement('label');
    label23.setAttribute('for', 'input23');
    label23.innerHTML = '12 Pack';

    theDiv23.append(label23);
    theDiv23.append(input23);
    theDiv23.append(theDiv52);

    var input24 = document.createElement('input');
    input24.setAttribute('type', 'radio');
    input24.setAttribute('name', 'beerCaseSize');
    input24.setAttribute('value', 'TWENTY_FOUR_PACK');
    input24.setAttribute('class', 'form-control box');
    input24.setAttribute('id', 'input24');

    var label24 = document.createElement('label');
    label24.setAttribute('for', 'input24');
    label24.innerHTML = '24 Pack';

    theDiv24.append(label24);
    theDiv24.append(input24);
    theDiv24.append(theDiv53);

    var input25 = document.createElement('input');
    input25.setAttribute('type', 'radio');
    input25.setAttribute('name', 'beerCaseSize');
    input25.setAttribute('value', 'FIVE_SEVENTEEN_GAL_KEG');
    input25.setAttribute('class', 'form-control box');
    input25.setAttribute('id', 'input25');

    var label25 = document.createElement('label');
    label25.setAttribute('for', 'input25');
    label25.innerHTML = '5.17 Gallon Keg';

    theDiv25.append(label25);
    theDiv25.append(input25);
    theDiv25.append(theDiv54);

    var input26 = document.createElement('input');
    input26.setAttribute('type', 'radio');
    input26.setAttribute('name', 'beerCaseSize');
    input26.setAttribute('value', 'SEVEN_SEVEN_FIVE_GAL_KEG');
    input26.setAttribute('class', 'form-control box');
    input26.setAttribute('id', 'input26');

    var label26 = document.createElement('label');
    label26.setAttribute('for', 'input26');
    label26.innerHTML = '7.75 Gallon Keg';

    theDiv26.append(label26);
    theDiv26.append(input26);
    theDiv26.append(theDiv55);

    var input27 = document.createElement('input');
    input27.setAttribute('type', 'radio');
    input27.setAttribute('name', 'beerCaseSize');
    input27.setAttribute('value', 'FIFTEEN_FIVE_GAL_KEG');
    input27.setAttribute('class', 'form-control box');
    input27.setAttribute('id', 'input27');

    var label27 = document.createElement('label');
    label27.setAttribute('for', 'input27');
    label27.innerHTML = '15.5 Gallon Keg';

    theDiv27.append(label27);
    theDiv27.append(input27);
    theDiv27.append(theDiv56);

    var input28 = document.createElement('input');
    input28.setAttribute('type', 'radio');
    input28.setAttribute('name', 'beerCaseSize');
    input28.setAttribute('value', 'TWENTY_LITRE_KEG');
    input28.setAttribute('class', 'form-control box');
    input28.setAttribute('id', 'input28');

    var label28 = document.createElement('label');
    label28.setAttribute('for', 'input28');
    label28.innerHTML = '20L Keg';

    theDiv28.append(label28);
    theDiv28.append(input28);
    theDiv28.append(theDiv57);

    var input29 = document.createElement('input');
    input29.setAttribute('type', 'radio');
    input29.setAttribute('name', 'beerCaseSize');
    input29.setAttribute('value', 'FIFTY_LITRE_KEG');
    input29.setAttribute('class', 'form-control box');
    input29.setAttribute('id', 'input29');

    var label29 = document.createElement('label');
    label29.setAttribute('for', 'input29');
    label29.innerHTML = '50L Keg';

    theDiv29.append(label29);
    theDiv29.append(input29);
    theDiv29.append(theDiv58);

    var beerButton = document.createElement('button');
    beerButton.setAttribute('type', 'submit');
    beerButton.setAttribute('class', 'btn btn-primary');
    beerButton.innerHTML = 'Submit';

    myForm.appendChild(theDiv1);
    myForm.appendChild(theDiv2);
    myForm.appendChild(theDiv3);
    myForm.appendChild(theDiv4);
    myForm.appendChild(theDiv5);
    myForm.appendChild(theDiv6);
    myForm.appendChild(theDiv7);
    myForm.appendChild(theDiv8);
    myForm.appendChild(theDiv9);
    myForm.appendChild(theDiv10);
    myForm.appendChild(theDiv11);
    myForm.appendChild(theDiv12);
    myForm.appendChild(theDiv13);
    myForm.appendChild(theDiv14);
    myForm.appendChild(theDiv15);
    myForm.appendChild(theDiv16);
    myForm.appendChild(theDiv17);
    myForm.appendChild(theDiv18);
    myForm.appendChild(domDiv);
    myForm.appendChild(seaDiv);
    myForm.appendChild(theDiv19);
    myForm.appendChild(theDiv20);
    myForm.appendChild(theDiv21);
    myForm.appendChild(theDiv22);
    myForm.appendChild(theDiv23);
    myForm.appendChild(theDiv24);
    myForm.appendChild(theDiv25);
    myForm.appendChild(theDiv26);
    myForm.appendChild(theDiv27);
    myForm.appendChild(theDiv28);
    myForm.appendChild(theDiv29);

    beerButton.setAttribute('onclick', 'createBeer(event)');

    var lastDiv = document.createElement('div');
    lastDiv.setAttribute('class', 'col-md-2');
    lastDiv.append(beerButton);

    myForm.appendChild(lastDiv);

    for (var i = 0; i < 31; i++) {
        var divTarget = $('#parent' + i);
        divTarget.onmouseover = function() {
            document.getElementById('popup' + i).style.display = 'block';
        }
        divTarget.onmouseout = function() {
            document.getElementById('popup' + i).style.visibility = 'hidden';
        }
    }
    row.append(myForm);
}

function createBeer(event) {
    event.preventDefault();

    var f = $('#theBeerForm');
    var vin = f.find('[name=lotDate]').val();
    var vari = f.find('[name=expirationDate]').val();
    var iColor = f.find('[name=beerType]').val();
    var imp = f.find('[name=Brewery]').val();
    var name = f.find('[name=name]').val();
    var desc = f.find('[name=description]').val();
    var itemC = f.find('[name=itemCode]').val();
    var orig = f.find('[name=origin]').val();
    var vol = f.find('[name=volume]').val();
    var frontP = f.find('[name=frontPrice]').val();
    var tenCP = f.find('[name=tenCasePrice]').val();
    var twentyFCP = f.find('[name=twentyFiveCasePrice]').val();
    var theCost = f.find('[name=cost]').val();
    var bottleW = f.find('[name=bottleWeight]').val();
    var caseW = f.find('[name=caseWeight]').val();
    var quantity = f.find('[name=quantity]').val();
    var exclu;
    var dualS;
    var theDomes;
    var theSeasons;
    if ($("#theBeerForm input[id='input17']:checked").val() == 'on') {
        exclu = true;
    } else {
        exclu = false;
    }

    if ($("#theBeerForm input[id='input18']:checked").val() == 'on') {
        dualS = true;
    } else {
        dualS = false;
    }

    if ($("#theBeerForm input[id='input30']:checked").val() == 'on') {
        theDomes = true;
    } else {
        theDomes = false;
    }

    if ($("#theBeerForm input[id='input31']:checked").val() == 'on') {
        theSeasons = true;
    } else {
        theSeasons = false;
    }

    var wCS = $("#theBeerForm input[type='radio']:checked").val();

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
            document.getElementById('theBeerForm').reset();
        }
    });
}

function liquorView(Event) {
    event.preventDefault();
    var row = $('#myContainer');
    row.empty();

    var liquorHeader = document.createElement('h1');
    liquorHeader.setAttribute('id', 'liquorHeader');
    liquorHeader.innerHTML = "Liquor Creation Sheet";

    row.append(liquorHeader);

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
    wineBtn.setAttribute('onclick', 'wineView(event)');

    var beerLabel = document.createElement('label');
    beerLabel.setAttribute('class', 'btn btn-primary selector');
    beerLabel.innerHTML = "Beer";

    var beerBtn = document.createElement('input');
    beerBtn.setAttribute('type', 'radio');
    beerBtn.setAttribute('name', 'options');
    beerBtn.setAttribute('id', 'option2');
    beerBtn.setAttribute('autocomplete', 'off');
    beerBtn.setAttribute('onclick', 'beerView(event)');

    var liquorLabel = document.createElement('label');
    liquorLabel.setAttribute('class', 'btn btn-primary selector');
    liquorLabel.innerHTML = "Liquour";

    var liquorBtn = document.createElement('input');
    liquorBtn.setAttribute('type', 'radio');
    liquorBtn.setAttribute('name', 'options');
    liquorBtn.setAttribute('id', 'option3');
    liquorBtn.setAttribute('autocomplete', 'off');
    liquorBtn.setAttribute('onclick', 'liquorView(event)');

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

    var theDiv1 = document.createElement('div');
    theDiv1.setAttribute('class', 'col-md-2');
    theDiv1.setAttribute('id', 'parent');

    var theDiv2 = document.createElement('div');
    theDiv2.setAttribute('class', 'col-md-2');
    theDiv2.setAttribute('id', 'parent1');

    var theDiv3 = document.createElement('div');
    theDiv3.setAttribute('class', 'col-md-2');
    theDiv3.setAttribute('id', 'parent2');

    var theDiv4 = document.createElement('div');
    theDiv4.setAttribute('class', 'col-md-2');
    theDiv4.setAttribute('id', 'parent3');

    var theDiv5 = document.createElement('div');
    theDiv5.setAttribute('class', 'col-md-2');
    theDiv5.setAttribute('id', 'parent4');

    var theDiv6 = document.createElement('div');
    theDiv6.setAttribute('class', 'col-md-2');
    theDiv6.setAttribute('id', 'parent5');

    var theDiv7 = document.createElement('div');
    theDiv7.setAttribute('class', 'col-md-2');
    theDiv7.setAttribute('id', 'parent6');

    var theDiv8 = document.createElement('div');
    theDiv8.setAttribute('class', 'col-md-2');
    theDiv8.setAttribute('id', 'parent7');

    var theDiv9 = document.createElement('div');
    theDiv9.setAttribute('class', ' col-md-2');
    theDiv9.setAttribute('id', 'parent8');

    var theDiv10 = document.createElement('div');
    theDiv10.setAttribute('class', ' col-md-2');
    theDiv10.setAttribute('id', 'parent9');

    var theDiv11 = document.createElement('div');
    theDiv11.setAttribute('class', ' col-md-2');
    theDiv11.setAttribute('id', 'parent10');

    var theDiv12 = document.createElement('div');
    theDiv12.setAttribute('class', ' col-md-2');
    theDiv12.setAttribute('id', 'parent11');

    var theDiv13 = document.createElement('div');
    theDiv13.setAttribute('class', ' col-md-2');
    theDiv13.setAttribute('id', 'parent12');

    var theDiv14 = document.createElement('div');
    theDiv14.setAttribute('class', ' col-md-2');
    theDiv14.setAttribute('id', 'parent13');

    var theDiv15 = document.createElement('div');
    theDiv15.setAttribute('class', ' col-md-2');
    theDiv15.setAttribute('id', 'parent14');

    var theDiv16 = document.createElement('div');
    theDiv16.setAttribute('class', ' col-md-2');
    theDiv16.setAttribute('id', 'parent15');

    var theDiv17 = document.createElement('div');
    theDiv17.setAttribute('class', ' col-md-2');
    theDiv17.setAttribute('id', 'parent16');

    var theDiv18 = document.createElement('div');
    theDiv18.setAttribute('class', ' col-md-2');
    theDiv18.setAttribute('id', 'parent17');

    var theDiv19 = document.createElement('div');
    theDiv19.setAttribute('class', ' col-md-2');
    theDiv19.setAttribute('id', 'parent18');

    var theDiv20 = document.createElement('div');
    theDiv20.setAttribute('class', ' col-md-2');
    theDiv20.setAttribute('id', 'parent19');

    var theDiv21 = document.createElement('div');
    theDiv21.setAttribute('class', ' col-md-2');
    theDiv21.setAttribute('id', 'parent20');

    var theDiv22 = document.createElement('div');
    theDiv22.setAttribute('class', ' col-md-2');
    theDiv22.setAttribute('id', 'parent21');

    var theDiv23 = document.createElement('div');
    theDiv23.setAttribute('class', ' col-md-2');
    theDiv23.setAttribute('id', 'parent22');

    var theDiv24 = document.createElement('div');
    theDiv24.setAttribute('class', ' col-md-2');
    theDiv24.setAttribute('id', 'parent23');

    var theDiv25 = document.createElement('div');
    theDiv25.setAttribute('class', ' col-md-2');
    theDiv25.setAttribute('id', 'parent24');

    var theDiv26 = document.createElement('div');
    theDiv26.setAttribute('class', ' col-md-2');
    theDiv26.setAttribute('id', 'parent25');

    var theDiv27 = document.createElement('div');
    theDiv27.setAttribute('class', ' col-md-2');
    theDiv27.setAttribute('id', 'parent26');

    var theDiv28 = document.createElement('div');
    theDiv28.setAttribute('class', ' col-md-2');
    theDiv28.setAttribute('id', 'parent27');

    var theDiv29 = document.createElement('div');
    theDiv29.setAttribute('class', ' col-md-2');
    theDiv29.setAttribute('id', 'parent28');

    var theDiv30 = document.createElement('div');
    theDiv30.setAttribute('class', 'col-md-1');
    theDiv30.setAttribute('id', 'popup1');
    theDiv30.innerHTML = 'Enter liquor type';

    var theDiv31 = document.createElement('div');
    theDiv31.setAttribute('class', ' col-md-1');
    theDiv31.setAttribute('id', 'popup2');
    theDiv31.innerHTML = 'Enter product distillery';

    var theDiv32 = document.createElement('div');
    theDiv32.setAttribute('class', ' col-md-1');
    theDiv32.setAttribute('id', 'popup3');
    theDiv32.innerHTML = 'Enter product name';

    var theDiv33 = document.createElement('div');
    theDiv33.setAttribute('class', ' col-md-1');
    theDiv33.setAttribute('id', 'popup4');
    theDiv33.innerHTML = 'Enter product description';

    var theDiv34 = document.createElement('div');
    theDiv34.setAttribute('class', ' col-md-1');
    theDiv34.setAttribute('id', 'popup5');
    theDiv34.innerHTML = 'Enter product itemcode';

    var theDiv35 = document.createElement('div');
    theDiv35.setAttribute('class', ' col-md-1');
    theDiv35.setAttribute('id', 'popup6');
    theDiv35.innerHTML = 'Enter product origin';

    var theDiv36 = document.createElement('div');
    theDiv36.setAttribute('class', ' col-md-1');
    theDiv36.setAttribute('id', 'popup7');
    theDiv36.innerHTML = 'Enter product volume';

    var theDiv37 = document.createElement('div');
    theDiv37.setAttribute('class', ' col-md-1');
    theDiv37.setAttribute('id', 'popup8');
    theDiv37.innerHTML = 'Enter product front price';

    var theDiv38 = document.createElement('div');
    theDiv38.setAttribute('class', ' col-md-1');
    theDiv38.setAttribute('id', 'popup9');
    theDiv38.innerHTML = 'Enter product 10 case price';

    var theDiv39 = document.createElement('div');
    theDiv39.setAttribute('class', ' col-md-1');
    theDiv39.setAttribute('id', 'popup10');
    theDiv39.innerHTML = 'Enter product 25 case price';

    var theDiv40 = document.createElement('div');
    theDiv40.setAttribute('class', ' col-md-1');
    theDiv40.setAttribute('id', 'popup11');
    theDiv40.innerHTML = 'Enter product cost';

    var theDiv41 = document.createElement('div');
    theDiv41.setAttribute('class', ' col-md-1');
    theDiv41.setAttribute('id', 'popup12');
    theDiv41.innerHTML = 'Enter product weight by bottle';

    var theDiv42 = document.createElement('div');
    theDiv42.setAttribute('class', ' col-md-1');
    theDiv42.setAttribute('id', 'popup13');
    theDiv42.innerHTML = 'Enter product weight by case';

    var theDiv43 = document.createElement('div');
    theDiv43.setAttribute('class', ' col-md-1');
    theDiv43.setAttribute('id', 'popup14');
    theDiv43.innerHTML = 'Enter product quantity';

    var theDiv44 = document.createElement('div');
    theDiv44.setAttribute('class', ' col-md-1');
    theDiv44.setAttribute('id', 'popup15');
    theDiv44.innerHTML = 'Check if product is promised to a customer';

    var theDiv45 = document.createElement('div');
    theDiv45.setAttribute('class', ' col-md-1');
    theDiv45.setAttribute('id', 'popup16');
    theDiv45.innerHTML = 'Check if product is able to be sold in both states';

    var theDiv46 = document.createElement('div');
    theDiv46.setAttribute('class', ' col-md-1');
    theDiv46.setAttribute('id', 'popup17');
    theDiv46.innerHTML = 'Check if product comes in 1 pack cases';

    var theDiv47 = document.createElement('div');
    theDiv47.setAttribute('class', ' col-md-1');
    theDiv47.setAttribute('id', 'popup18');
    theDiv47.innerHTML = 'Check if product comes in 3 pack cases';

    var theDiv48 = document.createElement('div');
    theDiv48.setAttribute('class', ' col-md-1');
    theDiv48.setAttribute('id', 'popup19');
    theDiv48.innerHTML = 'Check if product comes in 6 pack cases';

    var theDiv49 = document.createElement('div');
    theDiv49.setAttribute('class', ' col-md-1');
    theDiv49.setAttribute('id', 'popup20');
    theDiv49.innerHTML = 'Check if product comes in 9 pack cases';

    var theDiv50 = document.createElement('div');
    theDiv50.setAttribute('class', ' col-md-1');
    theDiv50.setAttribute('id', 'popup21');
    theDiv50.innerHTML = 'Check if product comes in 12 pack cases';

    var theDiv51 = document.createElement('div');
    theDiv51.setAttribute('class', ' col-md-1');
    theDiv51.setAttribute('id', 'popup22');
    theDiv51.innerHTML = 'Check if product comes in 24 pack cases';

    var theDiv52 = document.createElement('div');
    theDiv52.setAttribute('class', ' col-md-1');
    theDiv52.setAttribute('id', 'popup23');
    theDiv52.innerHTML = 'Check if product comes in 5.17 gallon kegs';

    var theDiv53 = document.createElement('div');
    theDiv53.setAttribute('class', ' col-md-1');
    theDiv53.setAttribute('id', 'popup24');
    theDiv53.innerHTML = 'Check if product comes in 7.75 gallon kegs';

    var theDiv54 = document.createElement('div');
    theDiv54.setAttribute('class', ' col-md-1');
    theDiv54.setAttribute('id', 'popup25');
    theDiv54.innerHTML = 'Check if product comes in 15.5 gallon kegs';

    var theDiv55 = document.createElement('div');
    theDiv55.setAttribute('class', ' col-md-1');
    theDiv55.setAttribute('id', 'popup26');
    theDiv55.innerHTML = 'Check if product comes in 20L gallon kegs';

    var theDiv56 = document.createElement('div');
    theDiv56.setAttribute('class', ' col-md-1');
    theDiv56.setAttribute('id', 'popup27');
    theDiv56.innerHTML = 'Check if product comes in 50L gallon kegs';

    var myForm = document.createElement('form');
    myForm.setAttribute('name', 'liquorForm');
    myForm.setAttribute('id', 'theLiquorForm');

    var input1 = document.createElement('input');
    input1.setAttribute('type', 'text');
    input1.setAttribute('name', 'liquorType');
    input1.setAttribute('class', 'form-control');
    input1.setAttribute('id', 'input1');

    var label1 = document.createElement('label');
    label1.setAttribute('for', 'input1');
    label1.innerHTML = "Liqour Type";

    theDiv1.append(label1);
    theDiv1.append(input1);
    theDiv1.append(theDiv30);

    var input2 = document.createElement('input');
    input2.setAttribute('type', 'text');
    input2.setAttribute('name', 'distillery');
    input2.setAttribute('class', 'form-control');
    input2.setAttribute('id', 'input2');

    var label2 = document.createElement('label');
    label2.setAttribute('for', 'input2');
    label2.innerHTML = 'Distillery';

    theDiv2.append(label2);
    theDiv2.append(input2);
    theDiv2.append(theDiv31);

    var input3 = document.createElement('input');
    input3.setAttribute('type', 'text');
    input3.setAttribute('name', 'name');
    input3.setAttribute('class', 'form-control');
    input3.setAttribute('id', 'input3');

    var label3 = document.createElement('label');
    label3.setAttribute('for', 'input3');
    label3.innerHTML = 'Name';

    theDiv3.append(label3);
    theDiv3.append(input3);
    theDiv3.append(theDiv32);

    var input4 = document.createElement('input');
    input4.setAttribute('type', 'text');
    input4.setAttribute('name', 'description');
    input4.setAttribute('class', 'form-control');
    input4.setAttribute('id', 'input4');

    var label4 = document.createElement('label');
    label4.setAttribute('for', 'input4');
    label4.innerHTML = 'Description';

    theDiv4.append(label4);
    theDiv4.append(input4);
    theDiv4.append(theDiv33);

    var input5 = document.createElement('input');
    input5.setAttribute('type', 'text');
    input5.setAttribute('name', 'itemCode');
    input5.setAttribute('class', 'form-control');
    input5.setAttribute('id', 'input5');

    var label5 = document.createElement('label');
    label5.setAttribute('for', 'input5');
    label5.innerHTML = 'Itemcode';

    theDiv5.append(label5);
    theDiv5.append(input5);
    theDiv5.append(theDiv34);

    var input6 = document.createElement('input');
    input6.setAttribute('type', 'text');
    input6.setAttribute('name', 'origin');
    input6.setAttribute('class', 'form-control');
    input6.setAttribute('id', 'input6');

    var label6 = document.createElement('label');
    label6.setAttribute('for', 'input6');
    label6.innerHTML = 'Origin';

    theDiv6.append(label6);
    theDiv6.append(input6);
    theDiv6.append(theDiv35);

    var input7 = document.createElement('input');
    input7.setAttribute('type', 'text');
    input7.setAttribute('name', 'volume');
    input7.setAttribute('class', 'form-control');
    input7.setAttribute('id', 'input7');

    var label7 = document.createElement('label');
    label7.setAttribute('for', 'input7');
    label7.innerHTML = 'Volume';

    theDiv7.append(label7);
    theDiv7.append(input7);
    theDiv7.append(theDiv36);

    var input8 = document.createElement('input');
    input8.setAttribute('type', 'text');
    input8.setAttribute('name', 'frontPrice');
    input8.setAttribute('class', 'form-control');
    input8.setAttribute('id', 'input8');

    var label8 = document.createElement('label');
    label8.setAttribute('for', 'input8');
    label8.innerHTML = 'Front Price';

    theDiv8.append(label8);
    theDiv8.append(input8);
    theDiv8.append(theDiv37);

    var input9 = document.createElement('input');
    input9.setAttribute('type', 'text');
    input9.setAttribute('name', 'tenCasePrice');
    input9.setAttribute('class', 'form-control');
    input9.setAttribute('id', 'input9');

    var label9 = document.createElement('label');
    label9.setAttribute('for', 'input9');
    label9.innerHTML = '10 Case Price';

    theDiv9.append(label9);
    theDiv9.append(input9);
    theDiv9.append(theDiv38);

    var input10 = document.createElement('input');
    input10.setAttribute('type', 'text');
    input10.setAttribute('name', 'twentyFiveCasePrice');
    input10.setAttribute('class', 'form-control');
    input10.setAttribute('id', 'input10');

    var label10 = document.createElement('label');
    label10.setAttribute('for', 'input10');
    label10.innerHTML = '25 Case Price';

    theDiv10.append(label10);
    theDiv10.append(input10);
    theDiv10.append(theDiv39);

    var input11 = document.createElement('input');
    input11.setAttribute('type', 'text');
    input11.setAttribute('name', 'cost');
    input11.setAttribute('class', 'form-control');
    input11.setAttribute('id', 'input11');

    var label11 = document.createElement('label');
    label11.setAttribute('for', 'input11');
    label11.innerHTML = 'Cost';

    theDiv11.append(label11);
    theDiv11.append(input11);
    theDiv11.append(theDiv40);

    var input12 = document.createElement('input');
    input12.setAttribute('type', 'text');
    input12.setAttribute('name', 'bottleWeight');
    input12.setAttribute('class', 'form-control');
    input12.setAttribute('id', 'input12');

    var label12 = document.createElement('label');
    label12.setAttribute('for', 'input12');
    label12.innerHTML = 'Bottle Weight';

    theDiv12.append(label12);
    theDiv12.append(input12);
    theDiv12.append(theDiv41);

    var input13 = document.createElement('input');
    input13.setAttribute('type', 'text');
    input13.setAttribute('name', 'caseWeight');
    input13.setAttribute('class', 'form-control');
    input13.setAttribute('id', 'input13');

    var label13 = document.createElement('label');
    label13.setAttribute('for', 'input13');
    label13.innerHTML = 'Case Weight';

    theDiv13.append(label13);
    theDiv13.append(input13);
    theDiv13.append(theDiv42);

    var input14 = document.createElement('input');
    input14.setAttribute('type', 'text');
    input14.setAttribute('name', 'quantity');
    input14.setAttribute('class', 'form-control');
    input14.setAttribute('id', 'input14');

    var label14 = document.createElement('label');
    label14.setAttribute('for', 'input14');
    label14.innerHTML = 'Quantity';

    theDiv14.append(label14);
    theDiv14.append(input14);
    theDiv14.append(theDiv43);

    var input15 = document.createElement('input');
    input15.setAttribute('type', 'checkbox');
    input15.setAttribute('name', 'isExclusive');
    input15.setAttribute('class', 'form-control');
    input15.setAttribute('id', 'input100');

    var label15 = document.createElement('label');
    label15.setAttribute('for', 'input100');
    label15.innerHTML = 'Exclusive';

    theDiv15.append(label15);
    theDiv15.append(input15);
    theDiv15.append(theDiv44);

    var input16 = document.createElement('input');
    input16.setAttribute('type', 'checkbox');
    input16.setAttribute('name', 'isDualState');
    input16.setAttribute('class', 'form-control');
    input16.setAttribute('id', 'input101');

    var label16 = document.createElement('label');
    label16.setAttribute('for', 'input101');
    label16.innerHTML = 'Dual State';

    theDiv16.append(label16);
    theDiv16.append(input16);
    theDiv16.append(theDiv45);

    var input17 = document.createElement('input');
    input17.setAttribute('type', 'radio');
    input17.setAttribute('name', 'liquorCaseSize');
    input17.setAttribute('value', 'ONE_PACK');
    input17.setAttribute('class', 'form-control box');
    input17.setAttribute('id', 'input17');

    var label17 = document.createElement('label');
    label17.setAttribute('for', 'input17');
    label17.innerHTML = '1 Pack';

    theDiv17.append(label17);
    theDiv17.append(input17);
    theDiv17.append(theDiv46);

    var input18 = document.createElement('input');
    input18.setAttribute('type', 'radio');
    input18.setAttribute('name', 'liquorCaseSize');
    input18.setAttribute('value', 'THREE_PACK');
    input18.setAttribute('class', 'form-control box');
    input18.setAttribute('id', 'input18');

    var label18 = document.createElement('label');
    label18.setAttribute('for', 'input18');
    label18.innerHTML = '3 Pack';

    theDiv18.append(label18);
    theDiv18.append(input18);
    theDiv18.append(theDiv47);

    var input19 = document.createElement('input');
    input19.setAttribute('type', 'radio');
    input19.setAttribute('name', 'beerCaseSize');
    input19.setAttribute('value', 'SIX_PACK');
    input19.setAttribute('class', 'form-control box');
    input19.setAttribute('id', 'input19');

    var label19 = document.createElement('label');
    label19.setAttribute('for', 'input19');
    label19.innerHTML = '6 Pack';

    theDiv19.append(label19);
    theDiv19.append(input19);
    theDiv19.append(theDiv48);

    var input20 = document.createElement('input');
    input20.setAttribute('type', 'radio');
    input20.setAttribute('name', 'beerCaseSize');
    input20.setAttribute('value', 'NINE_PACK');
    input20.setAttribute('class', 'form-control box');
    input20.setAttribute('id', 'input20');

    var label20 = document.createElement('label');
    label20.setAttribute('for', 'input20');
    label20.innerHTML = '9 Pack';

    theDiv20.append(label20);
    theDiv20.append(input20);
    theDiv20.append(theDiv49);

    var input21 = document.createElement('input');
    input21.setAttribute('type', 'radio');
    input21.setAttribute('name', 'beerCaseSize');
    input21.setAttribute('value', 'TWELVE_PACK');
    input21.setAttribute('class', 'form-control box');
    input21.setAttribute('id', 'input21');

    var label23 = document.createElement('label');
    label23.setAttribute('for', 'input21');
    label23.innerHTML = '12 Pack';

    theDiv21.append(label23);
    theDiv21.append(input21);
    theDiv21.append(theDiv50);

    var input22 = document.createElement('input');
    input22.setAttribute('type', 'radio');
    input22.setAttribute('name', 'beerCaseSize');
    input22.setAttribute('value', 'TWENTY_FOUR_PACK');
    input22.setAttribute('class', 'form-control box');
    input22.setAttribute('id', 'input22');

    var label22 = document.createElement('label');
    label22.setAttribute('for', 'input22');
    label22.innerHTML = '24 Pack';

    theDiv22.append(label22);
    theDiv22.append(input22);
    theDiv22.append(theDiv51);

    var input23 = document.createElement('input');
    input23.setAttribute('type', 'radio');
    input23.setAttribute('name', 'beerCaseSize');
    input23.setAttribute('value', 'FIVE_SEVENTEEN_GAL_KEG');
    input23.setAttribute('class', 'form-control box');
    input23.setAttribute('id', 'input23');

    var label23 = document.createElement('label');
    label23.setAttribute('for', 'input23');
    label23.innerHTML = '5.17 Gallon Keg';

    theDiv23.append(label23);
    theDiv23.append(input23);
    theDiv23.append(theDiv52);

    var input24 = document.createElement('input');
    input24.setAttribute('type', 'radio');
    input24.setAttribute('name', 'beerCaseSize');
    input24.setAttribute('value', 'SEVEN_SEVEN_FIVE_GAL_KEG');
    input24.setAttribute('class', 'form-control box');
    input24.setAttribute('id', 'input24');

    var label24 = document.createElement('label');
    label24.setAttribute('for', 'input24');
    label24.innerHTML = '7.75 Gallon Keg';

    theDiv24.append(label24);
    theDiv24.append(input24);
    theDiv24.append(theDiv53);

    var input25 = document.createElement('input');
    input25.setAttribute('type', 'radio');
    input25.setAttribute('name', 'beerCaseSize');
    input25.setAttribute('value', 'FIFTEEN_FIVE_GAL_KEG');
    input25.setAttribute('class', 'form-control box');
    input25.setAttribute('id', 'input25');

    var label25 = document.createElement('label');
    label25.setAttribute('for', 'input25');
    label25.innerHTML = '15.5 Gallon Keg';

    theDiv25.append(label25);
    theDiv25.append(input25);
    theDiv25.append(theDiv54);

    var input26 = document.createElement('input');
    input26.setAttribute('type', 'radio');
    input26.setAttribute('name', 'beerCaseSize');
    input26.setAttribute('value', 'TWENTY_LITRE_KEG');
    input26.setAttribute('class', 'form-control box');
    input26.setAttribute('id', 'input26');

    var label26 = document.createElement('label');
    label26.setAttribute('for', 'input26');
    label26.innerHTML = '20L Keg';

    theDiv26.append(label26);
    theDiv26.append(input26);
    theDiv26.append(theDiv55);

    var input27 = document.createElement('input');
    input27.setAttribute('type', 'radio');
    input27.setAttribute('name', 'beerCaseSize');
    input27.setAttribute('value', 'FIFTY_LITRE_KEG');
    input27.setAttribute('class', 'form-control box');
    input27.setAttribute('id', 'input27');

    var label27 = document.createElement('label');
    label27.setAttribute('for', 'input27');
    label27.innerHTML = '50L Keg';

    theDiv27.append(label27);
    theDiv27.append(input27);
    theDiv27.append(theDiv56);

    var liquorButton = document.createElement('button');
    liquorButton.setAttribute('type', 'submit');
    liquorButton.setAttribute('class', 'btn btn-primary');
    liquorButton.innerHTML = 'Submit';

    myForm.appendChild(theDiv1);
    myForm.appendChild(theDiv2);
    myForm.appendChild(theDiv3);
    myForm.appendChild(theDiv4);
    myForm.appendChild(theDiv5);
    myForm.appendChild(theDiv6);
    myForm.appendChild(theDiv7);
    myForm.appendChild(theDiv8);
    myForm.appendChild(theDiv9);
    myForm.appendChild(theDiv10);
    myForm.appendChild(theDiv11);
    myForm.appendChild(theDiv12);
    myForm.appendChild(theDiv13);
    myForm.appendChild(theDiv14);
    myForm.appendChild(theDiv15);
    myForm.appendChild(theDiv16);
    myForm.appendChild(theDiv17);
    myForm.appendChild(theDiv18);
    myForm.appendChild(theDiv19);
    myForm.appendChild(theDiv20);
    myForm.appendChild(theDiv21);
    myForm.appendChild(theDiv22);
    myForm.appendChild(theDiv23);
    myForm.appendChild(theDiv24);
    myForm.appendChild(theDiv25);
    myForm.appendChild(theDiv26);
    myForm.appendChild(theDiv27);

    liquorButton.setAttribute('onclick', 'createLiquor(event)');

    var lastDiv = document.createElement('div');
    lastDiv.setAttribute('class', 'col-md-2');
    lastDiv.append(liquorButton);

    myForm.appendChild(lastDiv);

    for (var i = 0; i < 31; i++) {
        var divTarget = $('#parent' + i);
        divTarget.onmouseover = function() {
            document.getElementById('popup' + i).style.display = 'block';
        }
        divTarget.onmouseout = function() {
            document.getElementById('popup' + i).style.visibility = 'hidden';
        }
    }
    row.append(myForm);
}

function createLiquor(event) {
    event.preventDefault();

    var f = $('#theLiquorForm');
    var vin = f.find('[name=liquorType]').val();
    var vari = f.find('[name=distillery]').val();
    var iColor = f.find('[name=name]').val();
    var imp = f.find('[name=description]').val();
    var name = f.find('[name=itemCode]').val();
    var desc = f.find('[name=origin]').val();
    var itemC = f.find('[name=volume]').val();
    var orig = f.find('[name=frontPrice]').val();
    var vol = f.find('[name=tenCasePrice]').val();
    var frontP = f.find('[name=twentyFiveCasePrice]').val();
    var tenCP = f.find('[name=cost]').val();
    var twentyFCP = f.find('[name=bottleWeight]').val();
    var theCost = f.find('[name=caseWeight]').val();
    var bottleW = f.find('[name=quantity]').val();
    var exclu;
    var dualS;
    if ($("#theLiquorForm input[id='input100']:checked").val() == 'on') {
        exclu = true;
    } else {
        exclu = false;
    }

    if ($("#theLiquorForm input[id='input101']:checked").val() == 'on') {
        dualS = true;
    } else {
        dualS = false;
    }

    var wCS = $("#theLiquorForm input[type='radio']:checked").val();

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
            document.getElementById('theLiquorForm').reset();
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

    var f = $('#invSearch');
    var item = f.find('[name=invBar]').val();
    console.log(item);
    // var itemN = f.find('[name=itemName]').val();
    // var imp = f.find('[name=importer]').val();

    $.ajax({
        url: '/search-products',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify({
          'item': item,
            // 'itemCode': itemC,
            // 'itemName': itemN,
            // 'importer': imp,
        }),
        success: function(data) {
            searchData(data);
        }
    });
}

function searchData(data) {
    console.log(data);
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


    var theContainer = $('#myContainer');

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
