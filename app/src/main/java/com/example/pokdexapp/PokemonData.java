package com.example.pokdexapp;

import java.util.ArrayList;


public class PokemonData {

    public static ArrayList<Pokemon> getPokemons() {

        ArrayList<Pokemon> pokemons = new ArrayList<>();

        pokemons.add(new Pokemon(
                "Bulbasaur",
                "Planta / Veneno",
                "Há uma semente de planta em suas costas desde o dia em que este Pokémon nasce. A semente cresce lentamente.",
                R.drawable.bulbasaur1
        ));

        pokemons.add(new Pokemon(
                "Ivysaur",
                "Planta / Veneno",
                "Há um bulbo em suas costas. Quando absorve nutrientes, o bulbo se transforma em uma grande flor.",
                R.drawable.ivysaur2
        ));

        pokemons.add(new Pokemon(
                "Venusaur",
                "Planta / Veneno",
                "Há uma grande flor em suas costas. A flor adquire cores vivas se receber muita nutrição e luz solar.",
                R.drawable.venusaur3
        ));

        pokemons.add(new Pokemon(
                "Charmander",
                "Fogo",
                "A chama que queima na ponta da sua cauda é um indicativo das suas emoções. A chama oscila quando está feliz.",
                R.drawable.charmander4
        ));

        pokemons.add(new Pokemon(
                "Charmeleon",
                "Fogo",
                "Charmeleon destrói seus oponentes impiedosamente usando suas garras afiadas. Ele se torna agressivo se encontrar um oponente forte.",
                R.drawable.charmeleon5
        ));

        pokemons.add(new Pokemon(
                "Charizard",
                "Fogo / Voador",
                "Charizard voa pelo céu em busca de oponentes poderosos. Ele cospe fogo de um calor tão intenso que derrete qualquer coisa.",
                R.drawable.charizard6
        ));

        pokemons.add(new Pokemon(
                "Squirtle",
                "Água",
                "A carapaça de Squirtle não serve apenas para proteção. A forma arredondada do casco ajuda a minimizar o atrito na água.",
                R.drawable.squirtle7
        ));

        pokemons.add(new Pokemon(
                "Wartortle",
                "Água",
                "Sua cauda é grande e coberta por uma pelagem espessa. Ela se torna cada vez mais profunda em cor à medida que ele envelhece.",
                R.drawable.wartortle8
        ));

        pokemons.add(new Pokemon(
                "Blastoise",
                "Água",
                "Blastoise possui jatos de água que se projetam de sua carapaça. Os jatos de água são muito precisos e poderosos.",
                R.drawable.blastoise9
        ));

        pokemons.add(new Pokemon(
                "Caterpie",
                "Inseto",
                "Caterpie tem um apetite voraz. Ele pode devorar folhas maiores do que o seu próprio corpo em questão de instantes.",
                R.drawable.caterpie10
        ));

        pokemons.add(new Pokemon(
                "Metapod",
                "Inseto",
                "A carapaça deste Pokémon é dura como uma chapa de ferro. Metapod não se move muito para preparar sua evolução.",
                R.drawable.metapod11
        ));

        pokemons.add(new Pokemon(
                "Butterfree",
                "Inseto / Voador",
                "Butterfree tem a grande habilidade de encontrar mel em flores. Consegue buscar mel em flores desabrochando a quilômetros.",
                R.drawable.butterfree12
        ));

        pokemons.add(new Pokemon(
                "Weedle",
                "Inseto / Veneno",
                "Weedle tem um olfato extremamente aguçado. Ele consegue distinguir suas folhas favoritas das que não gosta só de cheirar.",
                R.drawable.weedle13
        ));

        pokemons.add(new Pokemon(
                "Kakuna",
                "Inseto / Veneno",
                "Kakuna permanece praticamente imóvel enquanto se pendura em uma árvore. No entanto, sua atividade interna para evoluir é intensa.",
                R.drawable.kakuna14
        ));

        pokemons.add(new Pokemon(
                "Beedrill",
                "Inseto / Veneno",
                "Beedrill é extremamente territorial. Ninguém deve se aproximar de seu ninho, pois atacam em enxames impiedosos.",
                R.drawable.beedrill
        ));

        pokemons.add(new Pokemon(
                "Pidgey",
                "Normal / Voador",
                "Pidgey tem um senso de direção extremamente apurado. É capaz de voltar ao seu ninho por mais distante que esteja.",
                R.drawable.pidgey16
        ));

        pokemons.add(new Pokemon(
                "Pidgeotto",
                "Normal / Voador",
                "Pidgeotto reivindica uma grande área como o seu território. Ele voa patrulhando seu espaço constantemente.",
                R.drawable.pidgeotto17
        ));

        pokemons.add(new Pokemon(
                "Pidgeot",
                "Normal / Voador",
                "Este Pokémon tem uma plumagem deslumbrante de penas maravilhosamente brilhantes. É incrivelmente rápido no ar.",
                R.drawable.pidgeot18
        ));

        pokemons.add(new Pokemon(
                "Rattata",
                "Normal",
                "Rattata é cauteloso ao extremo. Mesmo quando está dormindo, ele constantemente escuta o ambiente movendo as orelhas.",
                R.drawable.rattata19
        ));

        pokemons.add(new Pokemon(
                "Raticate",
                "Normal",
                "As presas fortes de Raticate crescem continuamente. Para mantê-las afiadas, ele rói rochas e troncos rígidos.",
                R.drawable.raticate20
        ));

        return pokemons;
    }
}