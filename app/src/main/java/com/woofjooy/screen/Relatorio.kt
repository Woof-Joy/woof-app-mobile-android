import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.woofjooy.R
import com.woofjooy.components.Botao
import com.woofjooy.components.Title
import com.woofjooy.ui.theme.WoofJooyTheme

class Relatorio : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WoofJooyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Relatorio("Android")
                }
            }
        }
    }
}

@Composable
fun Relatorio(name: String, modifier: Modifier = Modifier) {

    var relatorioText by remember { mutableStateOf(TextFieldValue()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .height(100.dp)
            .background(color = colorResource(R.color.branco)),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ){
        Row (
            modifier = Modifier
                .padding(20.dp)
        ){
            Title(text = stringResource(R.string.title_relatorio))
        }

        Column(
            modifier = Modifier
                .padding(20.dp)
        ) {
            Row {
                Text(
                    text = "Faça um relatório detalhado sobre o serviço.",
                )
            }
            Row {
                Text(
                    text = "Tente descrever o que foi feito, atividades com o pet e seus comportamentos.",
                )
            }
        }

        val rosaEscuro = colorResource(id = R.color.rosa_escuro)
        Row {
            TextField(
                value = relatorioText,
                onValueChange = {relatorioText = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .border(1.dp, rosaEscuro, RoundedCornerShape(15.dp))
                    .verticalScroll(rememberScrollState())
                    .height(400.dp),
                maxLines = 600,
                placeholder = {
                    Text(
                        text = "Digite aqui...",
                        color = Color.DarkGray
                    )},
                shape = RoundedCornerShape(15.dp)
            )
        }

        Row(
            modifier = Modifier
                .padding(20.dp, 0.dp)
        ){
            Text(
                text = "* O preenchimento do relatório é obrigatório! Lembre-se que pode fazer toda a diferença na avaliação do seu serviço.",
            )
        }

        Row(
            modifier = Modifier
                .padding(20.dp)
        ){
            Botao(
                texto = "Enviar",
                fontSize = 16.sp,
                color = colorResource(id = R.color.branco),
                background = colorResource(id = R.color.rosa_escuro),
                modifier = Modifier
                    .size(400.dp, 40.dp),
                onClick = {
                    // Implementar ação do botão aqui
                }
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview4() {
    WoofJooyTheme {
        Relatorio("Android")
    }
}