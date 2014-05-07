[:head
 [:meta {:charset (:charset site)}]
 [:title (:title site)]
 (js ["/js/masonry.pkgd.min.js"])
 (css ["/css/normalize.css"
       "/css/foundation.min.css"
       "/css/main.css"])]
; /head

[:body
 [:div contents]
 (js ["/js/main.js"])]
; /body
