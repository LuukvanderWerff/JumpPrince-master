module JumpKing {
    requires hanyaeger;

    exports com.github.hanyaeger.tutorial;


    opens audio;
    opens backgrounds;
    opens sprites;
    exports com.github.hanyaeger.tutorial.entities.King;
    exports com.github.hanyaeger.tutorial.entities.text;
    exports com.github.hanyaeger.tutorial.entities.map;
    exports com.github.hanyaeger.tutorial.Scenes;
    exports com.github.hanyaeger.tutorial.Button;
    exports com.github.hanyaeger.tutorial.entities.map.Interactable;
    exports com.github.hanyaeger.tutorial.entities.map.Interactable.Items;
}
