; @layout  index
; @title   Lubov Soltan - Home

(def images
  "http://moolver-sin.deviantart.com/art/Girl-in-hat-286862494
   http://moolver-sin.deviantart.com/art/Look-in-her-eyes-253242373
   http://moolver-sin.deviantart.com/art/Fighter-453252444")

(logo)
(main-nav)
(galleries-nav "concept_art")

[:div#container
 (pmap image (urls-for images))]
