; @layout  index
; @title   Lubov Soltan - Home

(def images
  "http://moolver-sin.deviantart.com/art/Olga-400134129
   http://moolver-sin.deviantart.com/art/Kate-the-mysterious-367590887
   http://moolver-sin.deviantart.com/art/Tanja-362056439
   http://moolver-sin.deviantart.com/art/Joey-Jordisson-Murderdolls-295288406
   http://moolver-sin.deviantart.com/art/My-sweet-Mary-290286989
   http://moolver-sin.deviantart.com/art/Max-Gonzih-279182089
   http://moolver-sin.deviantart.com/art/Jake-Gyllenhaal-278520719
   http://moolver-sin.deviantart.com/art/Max-Gonzih-278371190
   http://moolver-sin.deviantart.com/art/Khal-Drogo-259801587
   http://moolver-sin.deviantart.com/art/Peter-Steele-Type-O-Negative-243453400
   http://moolver-sin.deviantart.com/art/Peter-Tagtgren-213246176
   http://moolver-sin.deviantart.com/art/Christian-Bale-209830247
   http://moolver-sin.deviantart.com/art/Max-207549641
   http://moolver-sin.deviantart.com/art/Kerry-King-205508133
   http://moolver-sin.deviantart.com/art/Dez-Fafara-204484050
   http://moolver-sin.deviantart.com/art/Maxim-196557811")

(logo)
(main-nav)
(galleries-nav "portraits")

[:div#container
 (pmap image (urls-for images))]
