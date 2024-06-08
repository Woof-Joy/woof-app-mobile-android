package com.woofjooy.components

import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.woofjooy.R
import com.woofjooy.datas.Servico
import com.woofjooy.screen.Relatorio
import com.woofjooy.ui.theme.WoofJooyTheme
import java.time.LocalDateTime


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Card(context: Servico, funPatch: () -> Unit, funDelete: () -> Unit) {

    val tipoServico = remember { mutableStateOf(context.tipoServico) }
    val status = remember { mutableStateOf(context.status) }

    val dataInicio = remember { mutableStateOf(context.dataInicio!!) }
    val dataFim = remember { mutableStateOf(context.dataFim!!) }


    val cliente = remember { mutableStateOf(context.cliente) }
    val colorText = when (status.value) {
        "Aguardando Confirmação" -> colorResource(R.color.preto)
        "Em Andamento" -> colorResource(R.color.preto)
        else -> colorResource(R.color.branco)
    }
    val boxColor = when (status.value) {
        "Aguardando Confirmação" -> colorResource(R.color.rosa_claro)
        "Em Andamento" -> colorResource(R.color.rosa_claro)
        else -> colorResource(R.color.rosa_escuro)
    }

    Box(
        modifier = Modifier
            .background(
                boxColor,
                shape = RoundedCornerShape(20.dp)
            )
            .size(350.dp, 160.dp)
            .border(2.dp, colorResource(R.color.rosa_escuro), shape = RoundedCornerShape(20.dp))

    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
        )
        {


            Column(
                modifier = Modifier
                    .padding(start = 13.dp, top = 8.dp, bottom = 5.dp)
            )
            {
                Text(
                    color = colorText,
                    text = status.value, fontSize = 15.sp,
                    modifier = Modifier
                        .padding(top = 4.dp, bottom = 2.dp)
                )
                Text(
                    color = colorText,
                    text = tipoServico.value,
                    fontSize = 13.sp,
                    modifier = Modifier
                        .padding(bottom = 5.dp)
                )

                val fdI = dataInicio.value
                val fdF = dataFim.value

                Text(
                    color = colorText,
                    text = "Inicio do serviço: ${fdI.dayOfMonth}/${fdI.monthValue}/${fdI.year}  ${fdI.hour}:${fdI.minute}",
                    fontSize = 10.sp,
                )
                Text(
                    color = colorText,
                    text = "Fim do serviço: ${fdF.dayOfMonth}/${fdF.monthValue}/${fdF.year}  ${fdF.hour}:${fdF.minute}",
                    fontSize = 10.sp,
                    modifier = Modifier
                        .padding(bottom = 5.dp)
                )

                Text(
                    color = colorText,
                    text = "Cliente: ${cliente.value}",
                    fontSize = 12.sp,
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(45.dp)
                    .padding(top = 5.dp)
            ) {
                when (status.value) {

                    "Aguardando Confirmação" -> {
                        Button(
                            colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.branco)),
                            modifier = Modifier
                                .weight(1f)
                                .padding(4.dp),

                        onClick = { funDelete() }) {
                            Text(
                                "Recusar",
                                color = colorResource(R.color.rosa_escuro),
                                fontSize = 12.sp
                            )
                        }

                        Button(
                            colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.rosa_escuro)),
                            modifier = Modifier
                                .weight(1f)
                                .padding(4.dp),

                            onClick = { funPatch() }) {
                            Text(
                                "Aceitar",
                                color = colorResource(R.color.branco),
                                fontSize = 12.sp
                            )
                        }
                    }

                    "Em Andamento" -> {

                        Button(
                            colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.rosa_escuro)),
                            modifier = Modifier
                                .padding(5.dp)
                                .fillMaxWidth(),

                            onClick = { funPatch() }) {
                            Text(
                                "Finalizar",
                                color = colorResource(R.color.branco),
                                fontSize = 12.sp
                            )
                        }
                    }

                    else -> {
                        val contexto = LocalContext.current
                        val home = Intent(contexto, Relatorio::class.java)


                        Button(
                            colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.branco)),
                            modifier = Modifier
                                .padding(5.dp)
                                .fillMaxWidth(),

                            onClick = { contexto.startActivity(home) }) {
                            Text(
                                "Relatório",
                                color = colorResource(R.color.rosa_escuro),
                                fontSize = 12.sp
                            )
                        }

                    }
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WoofJooyTheme {
        Card(
            Servico(
                status = "Aguardando Confirmação",
                dataInicio = LocalDateTime.now(),
                dataFim = LocalDateTime.now(),
                tipoServico = "Dog Walker",
                cliente = "Cliente Teste"
            ),
            funPatch = fun(){},
            funDelete =fun(){}
        )
    }
}