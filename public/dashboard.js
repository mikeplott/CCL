function inventoryView(Event) {
    event.preventDefault();
    var row = $('#myContainer');
    row.empty();

    var theNewDiv = $('#zeNav');

    var newDiv = document.createElement('div');
    newDiv.setAttribute('class', 'btn-group');
    newDiv.setAttribute('data-toggle', 'buttons');

    var dynNav = $('#theNav');

    var wineLabel = document.createElement('label');
    wineLabel.setAttribute('class', 'btn btn-primary selector');
    wineLabel.innerHTML = "Wine";

    var wineBtn = document.createElement('input');
    wineBtn.setAttribute('type', 'radio');
    wineBtn.setAttribute('name', 'options');
    wineBtn.setAttribute('id', 'option1');
    wineBtn.setAttribute('autocomplete', 'off');

    var beerLabel = document.createElement('label');
    beerLabel.setAttribute('class', 'btn btn-primary selector');
    beerLabel.innerHTML = "Beer";

    var beerBtn = document.createElement('input');
    beerBtn.setAttribute('type', 'radio');
    beerBtn.setAttribute('name', 'options');
    beerBtn.setAttribute('id', 'option2');
    beerBtn.setAttribute('autocomplete', 'off');

    var liquorLabel = document.createElement('label');
    liquorLabel.setAttribute('class', 'btn btn-primary selector');
    liquorLabel.innerHTML = "Liquour";

    var liquorBtn = document.createElement('input');
    liquorBtn.setAttribute('type', 'radio');
    liquorBtn.setAttribute('name', 'options');
    liquorBtn.setAttribute('id', 'option3');
    liquorBtn.setAttribute('autocomplete', 'off');

    wineLabel.append(wineBtn);
    beerLabel.append(beerBtn);
    liquorLabel.append(liquorBtn);

    newDiv.append(wineLabel);
    newDiv.append(beerLabel);
    newDiv.append(liquorLabel);

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
    theDiv30.innerHTML = 'Enter product vintage';

    var theDiv31 = document.createElement('div');
    theDiv31.setAttribute('class', ' col-md-1');
    theDiv31.setAttribute('id', 'popup2');
    theDiv31.innerHTML = 'Enter product varietal';

    var theDiv32 = document.createElement('div');
    theDiv32.setAttribute('class', ' col-md-1');
    theDiv32.setAttribute('id', 'popup3');
    theDiv32.innerHTML = 'Enter product color';

    var theDiv33 = document.createElement('div');
    theDiv33.setAttribute('class', ' col-md-1');
    theDiv33.setAttribute('id', 'popup4');
    theDiv33.innerHTML = 'Enter product importer';

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
    //myForm.setAttribute('class', 'form-inline');
    myForm.setAttribute('name', 'wineForm');
    myForm.setAttribute('id', 'theWineForm');

    var input1 = document.createElement('input');
    input1.setAttribute('type', 'text');
    input1.setAttribute('name', 'vintage');
    input1.setAttribute('class', 'form-control');
    input1.setAttribute('id', 'input1');

    var label1 = document.createElement('label');
    label1.setAttribute('for', 'input1');
    label1.innerHTML = "Vintage";

    theDiv1.append(label1);
    theDiv1.append(input1);
    theDiv1.append(theDiv30);

    var input2 = document.createElement('input');
    input2.setAttribute('type', 'text');
    input2.setAttribute('name', 'varietal');
    input2.setAttribute('class', 'form-control');
    input2.setAttribute('id', 'input2');

    var label2 = document.createElement('label');
    label2.setAttribute('for', 'input2');
    label2.innerHTML = 'Varietal';

    theDiv2.append(label2);
    theDiv2.append(input2);
    theDiv2.append(theDiv31);

    var input3 = document.createElement('input');
    input3.setAttribute('type', 'text');
    input3.setAttribute('name', 'color');
    input3.setAttribute('class', 'form-control');
    input3.setAttribute('id', 'input3');

    var label3 = document.createElement('label');
    label3.setAttribute('for', 'input3');
    label3.innerHTML = 'Color';

    theDiv3.append(label3);
    theDiv3.append(input3);
    theDiv3.append(theDiv32);

    var input4 = document.createElement('input');
    input4.setAttribute('type', 'text');
    input4.setAttribute('name', 'importer');
    input4.setAttribute('class', 'form-control');
    input4.setAttribute('id', 'input4');

    var label4 = document.createElement('label');
    label4.setAttribute('for', 'input4');
    label4.innerHTML = 'Importer';

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

    var label17 = document.createElement('label');
    label17.setAttribute('for', 'input17');
    label17.innerHTML = 'Exclusive';

    theDiv17.append(label17);
    theDiv17.append(input17);
    theDiv17.append(theDiv46);

    var input18 = document.createElement('input');
    input18.setAttribute('type', 'checkbox');
    input18.setAttribute('name', 'isDualState');
    input18.setAttribute('class', 'form-control box');
    input18.setAttribute('id', 'input18');

    var label18 = document.createElement('label');
    label18.setAttribute('for', 'input18');
    label18.innerHTML = 'Dual States';

    theDiv18.append(label18);
    theDiv18.append(input18);
    theDiv18.append(theDiv47);

    var input19 = document.createElement('input');
    input19.setAttribute('type', 'checkbox');
    input19.setAttribute('name', 'wineCaseSize');
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
    input20.setAttribute('type', 'checkbox');
    input20.setAttribute('name', 'wineCaseSize');
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
    input21.setAttribute('type', 'checkbox');
    input21.setAttribute('name', 'wineCaseSize');
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
    input22.setAttribute('type', 'checkbox');
    input22.setAttribute('name', 'wineCaseSize');
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
    input23.setAttribute('type', 'checkbox');
    input23.setAttribute('name', 'wineCaseSize');
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
    input24.setAttribute('type', 'checkbox');
    input24.setAttribute('name', 'wineCaseSize');
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
    input25.setAttribute('type', 'checkbox');
    input25.setAttribute('name', 'wineCaseSize');
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
    input26.setAttribute('type', 'checkbox');
    input26.setAttribute('name', 'wineCaseSize');
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
    input27.setAttribute('type', 'checkbox');
    input27.setAttribute('name', 'wineCaseSize');
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
    input28.setAttribute('type', 'checkbox');
    input28.setAttribute('name', 'wineCaseSize');
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
    input29.setAttribute('type', 'checkbox');
    input29.setAttribute('name', 'wineCaseSize');
    input29.setAttribute('value', 'FIFTY_LITRE_KEG');
    input29.setAttribute('class', 'form-control box');
    input29.setAttribute('id', 'input29');

    var label29 = document.createElement('label');
    label29.setAttribute('for', 'input29');
    label29.innerHTML = '50L Keg';

    theDiv29.append(label29);
    theDiv29.append(input29);
    theDiv29.append(theDiv58);

    var wineButton = document.createElement('button');
    wineButton.setAttribute('type', 'submit');
    wineButton.setAttribute('class', 'btn btn-primary');
    wineButton.innerHTML = 'Submit';

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
    myForm.appendChild(theDiv28);
    myForm.appendChild(theDiv29);

    var lastDiv = document.createElement('div');
    lastDiv.setAttribute('class', 'col-md-2');
    lastDiv.append(wineButton);

    myForm.appendChild(lastDiv);

    for (var i = 0; i < 30; i++) {
        var divTarget = $('#parent' + i);
        divTarget.onmouseover = function() {
            document.getElementById('popup' + i).style.display = 'block';
        }
        divTarget.onmouseout = function() {
            document.getElementById('popup' + i).style.visibility = 'hidden';
        }
    }

    document.body.appendChild(myForm);
}
