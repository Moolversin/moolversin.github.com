; @layout  index
; @title   Lubov Soltan - About, contacts.
; @description About me. Contact me.

[:div.header
 (logo)
 (main-nav)]

[:div#container
 [:div.row
  [:div.small-4.small-offset-3.columns
   [:p "I'm a varied artist, working with traditional and digital media in
        realistic and surrealistic manner, currently living in Amsterdam, the Netherlands."]]
  [:div.small-5.columns
   [:ul.vcard.contacts
    [:li.fn "Lubov Soltan"]
    [:li.email [:a {:href "mailto:lubarazgildeeva@gmail.com"} "Mail me!"]]
    [:li [:a {:href "https://plus.google.com/116635824809317777470/posts" :target "_blank"} "Google+"]]
    [:li [:a {:href "http://moolver-sin.deviantart.com/" :target "_blank"} "Deviant Art"]]
    [:li [:a {:href "https://www.behance.net/liubousoltan" :target "_blank"} "Behance"]]]]]
 [:div.row
  [:div.small-6.columns.small-centered
   [:img {:src "/img/me.jpg" :alt "Lubov Soltan"}]]]]
