/*
 * Copyright Applibgroup Huawei
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.pacoworks.rxtuples.slice;

import com.pacoworks.rxtuples.ResourceTable;
import com.pacoworks.rxtuples.RxTuples;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;
import ohos.agp.components.Component;
import ohos.agp.components.Text;
import ohos.agp.components.TextField;
import ohos.agp.window.dialog.ToastDialog;

import org.javatuples.Pair;
import org.javatuples.Triplet;
import rx.Observable;

public class FunctionAbilitySlice extends AbilitySlice {
    TextField entry_1;
    TextField entry_2;
    TextField entry_3;
    Button create_btn;
    Text display;
    Text enter_data3;

    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_slice_function);

        entry_1 = (TextField) findComponentById(ResourceTable.Id_entry_1);
        entry_2 = (TextField) findComponentById(ResourceTable.Id_entry_2);
        entry_3 = (TextField) findComponentById(ResourceTable.Id_entry_3);
        create_btn = (Button) findComponentById(ResourceTable.Id_create_btn);
        display = (Text) findComponentById(ResourceTable.Id_function_display_text);
        enter_data3 = (Text) findComponentById(ResourceTable.Id_enter_data3);


        if(intent!=null){
            int func = intent.getIntParam("function",1);
            if(func==1){
                enter_data3.setVisibility(Component.HIDE);
                entry_3.setVisibility(Component.HIDE);
                create_btn.setClickedListener(new Component.ClickedListener() {
                    @Override
                    public void onClick(Component component) {
                        createPair();
                    }
                });
            }
            else{
                enter_data3.setVisibility(Component.VISIBLE);
                entry_3.setVisibility(Component.VISIBLE);
                create_btn.setClickedListener(new Component.ClickedListener() {
                    @Override
                    public void onClick(Component component) {
                        createTriplet();
                    }
                });
            }

        }

    }

    private void createTriplet() {
        Observable result = Observable.zip(Observable.just(entry_1.getText()), Observable.just(entry_2.getText()),
                Observable.just(entry_3.getText()), RxTuples.<String, String,String>toTriplet());

        result.subscribe(tmp -> {
            Triplet<String,String,String> trip = (Triplet) tmp;
            new ToastDialog(getContext()).
                    setText("Success!").show();
            display.setText(trip.toString());
        });
    }

    private void createPair() {
        Observable result = Observable.zip(Observable.just(entry_1.getText()),Observable.just(entry_2.getText()),
                RxTuples.<String,String> toPair());

        result.subscribe(tmp -> {
            Pair<String,String> p = (Pair) tmp;
            new ToastDialog(getContext()).
                    setText("Success!").show();
            display.setText(p.toString());
        });
    }

    @Override
    protected void onBackground() {
        super.onBackground();
        entry_1.setText("");
        entry_2.setText("");
        entry_3.setText("");
        display.setText("");
    }
}
