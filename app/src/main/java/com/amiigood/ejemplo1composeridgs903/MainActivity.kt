package com.amiigood.ejemplo1composeridgs903

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.amiigood.ejemplo1composeridgs903.ui.theme.EjemploComposerIDGS903Theme

private val tarjetas: List<PersonajeTarjeta> = listOf(
    PersonajeTarjeta("Goku", "El protagonista de la serie, conocido por su gran poder y personalidad amigable. Originalmente enviado a la Tierra como un infante volador con la misión de conquistarla. Sin embargo, el caer por un barranco le proporcionó un brutal golpe que si bien casi lo mata, este alteró su memoria y anuló todos los instintos violentos de su especie, lo que lo hizo crecer con un corazón puro y bondadoso, pero conservando todos los poderes de su raza."),
    PersonajeTarjeta("Vegeta", "Príncipe de los Saiyans, inicialmente un villano, pero luego se une a los Z Fighters."),
    PersonajeTarjeta("Piccolo", "Es un namekiano que surgió tras ser creado en los últimos momentos de vida de su padre, siendo su actual reencarnación. Aunque en un principio fue el archienemigo de Son Goku, con el paso del tiempo fue haciéndose menos malvado hasta finalmente convertirse en un ser bondadoso y miembro de los Guerreros Z."),
    PersonajeTarjeta("Bulma", "Bulma es la protagonista femenina de la serie manga Dragon Ball y sus adaptaciones al anime Dragon Ball, Dragon Ball Z, Dragon Ball Super y Dragon Ball GT."),
    PersonajeTarjeta("Freezer", "Freezer es el tirano espacial y el principal antagonista de la saga de Freezer."),
    PersonajeTarjeta("Zarbon", "Zarbon es uno de los secuaces de Freezer y un luchador poderoso."),
    PersonajeTarjeta("Dodoria", "Dodoria es otro secuaz de Freezer conocido por su brutalidad."),
    PersonajeTarjeta("Ginyu", "Ginyu es el líder del la élite de mercenarios de mayor prestigio del Ejército de Freeza, la cual lleva el nombre de Fuerzas Especiales Ginew en su honor[9]."),
    PersonajeTarjeta("Celula", "Cell conocido como Célula en España, es un bioandroide creado por la computadora del Dr. Gero, quien vino del futuro de la línea 3 con la intención de vengarse de Goku por haber acabado con el Ejército del Listón Rojo, y con ello el sueño de todo villano: dominar el mundo. Es el antagonista principal del Arco de los Androides y Cell."),
    PersonajeTarjeta("Gohan", "Son Gohanda en su tiempo en España, o simplemente Gohan en Hispanoamérica, es uno de los personajes principales de los arcos argumentales de Dragon Ball Z, Dragon Ball Super y Dragon Ball GT. Es un mestizo entre saiyano y humano terrícola."),
    PersonajeTarjeta("Krillin", "Amigo cercano de Goku y guerrero valiente, es un personaje del manga y anime de Dragon Ball. Es uno de los principales discípulos de Kame-Sen'nin, Guerrero Z, y el mejor amigo de Son Goku. Es junto a Bulma uno de los personajes de apoyo principales de Dragon Ball, Dragon Ball Z y Dragon Ball Super."),
    PersonajeTarjeta("Tenshinhan", "Maestro de las artes marciales y miembro de los Z Fighters.  Es un personaje que aparece en el manga y en el anime de Dragon Ball, Dragon Ball Z, Dragon Ball GT y posteriormente en Dragon Ball Super.")
)

data class PersonajeTarjeta(val title: String, val body: String)


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            EjemploComposerIDGS903Theme {
                Tarjeta(tarjetas)
            }
        }
    }
}

@Composable
fun Personaje(name: String, color: Color, style: TextStyle){
    Text(text = name)
}

@Composable
fun Personajes(personaje: PersonajeTarjeta){
    Column {
        Personaje(personaje.title, MaterialTheme.colorScheme.primary, MaterialTheme.typography.headlineMedium)
        Personaje(personaje.body, MaterialTheme.colorScheme.onBackground, MaterialTheme.typography.bodyLarge)
    }
}

@Composable
fun ImagenHeroe(){
    Image(
        painter = painterResource(id = R.drawable.freezer),
        contentDescription = "Freezer",
        modifier = Modifier.padding(16.dp).size(100.dp).clip(CircleShape).background(MaterialTheme.colorScheme.primary)
    )
}

@Composable
fun Tarjeta(personajes: List<PersonajeTarjeta>){
    LazyColumn {
        items(personajes){ personaje ->
            for (personaje in personajes){
                MyPersonajes(personaje)
            }
        }
    }
}

@Composable
fun MyPersonajes(personaje: PersonajeTarjeta){
    Card(modifier = Modifier.padding(16.dp).fillMaxWidth(), elevation = CardDefaults.cardElevation(defaultElevation = 8.dp), shape = RoundedCornerShape(18.dp), colors = CardDefaults.cardColors(containerColor = Color.White)){

    }
    Row(modifier = Modifier.padding(8.dp).background(MaterialTheme.colorScheme.background)) {
        ImagenHeroe()
        Personajes(personaje)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Tarjeta(tarjetas)
}