package com.woofjooy.screen

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.woofjooy.R
import com.woofjooy.client.RetrofitClient
import com.woofjooy.components.Botao
import com.woofjooy.components.Input
import com.woofjooy.components.Title
import com.woofjooy.datas.Usuario
import com.woofjooy.datas.UsuarioLogin
import com.woofjooy.datas.UsuarioLoginRespose
import com.woofjooy.ui.theme.WoofJooyTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Login : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val extras = intent.extras
        setContent {
            WoofJooyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Login(extras)
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun Login(extras: Bundle?) {
    val contexto = LocalContext.current

    val email = remember {
        mutableStateOf("")
    }
    val senha = remember {
        mutableStateOf("")
    }
    val typePerfil = extras?.getString("typePerfil")


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.rosa_escuro)),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = painterResource(id = R.mipmap.logo_branca),
            contentDescription = "Logo da marca woofjoy",
            modifier = Modifier.size(150.dp)
        )
        Column(
            modifier = Modifier
                .background(
                    color = colorResource(R.color.branco),
                    shape = RoundedCornerShape(topStart = 80.dp, topEnd = 80.dp)
                )
                .height(6200.dp)
                .fillMaxWidth()
            ,
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Title(text = stringResource(R.string.boa_vindas_login))

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Input(valCampo = email, label = stringResource(R.string.label_email), modifier = Modifier
                    .border(3.dp, colorResource(R.color.rosa_escuro), shape = RoundedCornerShape(50.dp))
                    .width(300.dp)
                    .padding(10.dp))
                Spacer(modifier = Modifier.height(8.dp))
                Input(valCampo = senha, label = stringResource(R.string.label_senha), modifier = Modifier
                    .border(3.dp, colorResource(R.color.rosa_escuro), shape = RoundedCornerShape(50.dp))
                    .width(300.dp)
                    .padding(10.dp))
                Spacer(modifier = Modifier.height(16.dp)) // Adiciona um espaçamento entre os TextField e o Button
                Botao(stringResource(R.string.txt_botao_login), 16.sp,colorResource(R.color.branco), colorResource(
                    R.color.rosa_escuro,
                ), Modifier
                    .padding(start = 60.dp, end = 60.dp)
                    .width(200.dp),onClick = {
                    val usuarioLogin = UsuarioLogin(email.value, senha.value, typePerfil!!)
                    var usuarioLoginResponse=UsuarioLoginRespose(token = "")
                    RetrofitClient.instance.login(usuarioLogin).enqueue(object :
                        Callback<UsuarioLoginRespose> {
                        override fun onResponse(
                            call: Call<UsuarioLoginRespose>,
                            response: Response<UsuarioLoginRespose>
                        ) {
                            if (response.isSuccessful) {
                                val usuarioResponse = response.body()
                                if (usuarioResponse != null){
                                    usuarioLoginResponse.copy(
                                        userId = usuarioResponse.userId,
                                        nome = usuarioResponse.nome,
                                        email = usuarioResponse.email,
                                        role = usuarioResponse.role,
                                        token = usuarioResponse.token
                                    )
                                }
                            } else {
                              print("Erro ao tentar executar a função")
                            }
                        }
                        override fun onFailure(call: Call<UsuarioLoginRespose>, t: Throwable) {
                            TODO("Not yet implemented")
                        }
                    })


                    val dataUser=Usuario()
                    RetrofitClient.instance.getUserById(userId = usuarioLoginResponse.userId!!).enqueue(object :
                            Callback<Usuario> {
                            override fun onResponse(
                                call: Call<Usuario>,
                                response: Response<Usuario>
                            ) {
                                if (response.isSuccessful) {
                                    val usuarioResponse = response.body()
                                    if (usuarioResponse != null){
                                        dataUser.copy(
                                            id=usuarioResponse.id,
                                            nomeCompleto = usuarioResponse.nomeCompleto,
                                            cep=usuarioResponse.cep,
                                            cpf =usuarioResponse.cpf,
                                            dataNasc = usuarioResponse.dataNasc,
                                            descricao = usuarioResponse.descricao,
                                            email = usuarioResponse.email,
                                            imgUsuario = usuarioResponse.imgUsuario,
                                            senha = usuarioResponse.senha,
                                            numero = usuarioResponse.numero,
                                            listItens = usuarioResponse.listItens,
                                            cliente = usuarioResponse.cliente,
                                            parceiro = usuarioResponse.parceiro

                                        )
                                    }
                                } else {
                                    print("Erro ao tentar executar a função")
                                }
                            }
                            override fun onFailure(call: Call<Usuario>, t: Throwable) {
                                TODO("Not yet implemented")
                            }
                        })

                        val feed = Intent(contexto, Feed::class.java)
                        feed.putExtra("userToken", usuarioLoginResponse.token)
                        feed.putExtra("dataUser", dataUser)
                        contexto.startActivity(feed)



                })
            }

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(
                    "Ainda não tem uma conta?"
                )
                Text("Cadastre-se", style = TextStyle(fontWeight = FontWeight.Bold, color = colorResource(
                    R.color.rosa_escuro
                )
                )
                )
            }

        }
    }
}



@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    com.woofjooy.screen.ui.theme.WoofJooyTheme {
        Login()
    }
}



