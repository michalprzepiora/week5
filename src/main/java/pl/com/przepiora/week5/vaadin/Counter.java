package pl.com.przepiora.week5.vaadin;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("counter")
public class Counter extends VerticalLayout {
    public Counter() {
       if (MainView.counter.size()>0){
           for (int i = 0; i < MainView.counter.size(); i++) {
               Label label = new Label(MainView.counter.get(i));
               this.add(label);
           }
       }
    }
}
