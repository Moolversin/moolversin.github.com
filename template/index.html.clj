; @layout  index
; @title   Love Soltan

[:div.row
 [:div.small-3.small-centered.column
  [:img.logo {:src "http://placehold.it/160x60&text=Logo"}]]]

[:div.row
 [:div.small-5.column.small-centered.text-center
  [:ul.inline-list
   [:li [:a {:href "#"} "Link 1"]]
   [:li [:a {:href "#"} "Link 1"]]
   [:li [:a {:href "#"} "Link 1"]]
   [:li [:a {:href "#"} "Link 1"]]
   [:li [:a {:href "#"} "Link 1"]]
   [:li [:a {:href "#"} "Link 1"]]]]]

(defn image []
  [:a.item-link
   [:div.item
    [:img {:src "http://placehold.it/620x240/111111/eeeeee&text=Image"}]
    [:div.hide.overflow "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."]]])

[:div#container
 (image)
 (image)
 (image)
 (image)
 (image)
 (image)
 (image)
 (image)]
