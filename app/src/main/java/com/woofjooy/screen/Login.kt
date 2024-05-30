package com.woofjooy.screen

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.woofjooy.R
import com.woofjooy.client.RetrofitService
import com.woofjooy.components.Input
import com.woofjooy.components.Title
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
        setContent {
            WoofJooyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Login()
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun Login(nome:String, modifier: Modifier) {
    val contexto = LocalContext.current

    val email = remember {
        mutableStateOf("")
    }
    val senha = remember {
        mutableStateOf("")
    }
    val typePerfil = remember {
        mutableStateOf("P")
    }


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
                Input(valCampo = email, label = stringResource(R.string.label_email), placeholder = "Digite seu email", modifier = Modifier
                    .border(
                        3.dp,
                        colorResource(R.color.rosa_escuro),
                        shape = RoundedCornerShape(50.dp)
                    )
                    .width(300.dp)
                    .padding(10.dp))
                Spacer(modifier = Modifier.height(8.dp))
                Input(valCampo = senha, label = stringResource(R.string.label_senha), placeholder = "Digite sua senha", modifier = Modifier
                    .border(
                        3.dp,
                        colorResource(R.color.rosa_escuro),
                        shape = RoundedCornerShape(50.dp)
                    )
                    .width(300.dp)
                    .padding(10.dp))
                Spacer(modifier = Modifier.height(16.dp)) // Adiciona um espaçamento entre os TextField e o Button
                Button(
                    onClick = {
                        val usuarioLogin = UsuarioLogin(email = email.value, senha = senha.value, role= typePerfil.value)
                        var usuarioLoginResponse=UsuarioLoginRespose(token = "")
                        Log.d("api", "${email.value},${senha.value},${typePerfil}")

                        val api = RetrofitService.getApi()
                        val login = api.login(usuarioLogin)
                        login.enqueue(object : Callback<UsuarioLoginRespose> {
                            override fun onResponse(
                                call: Call<UsuarioLoginRespose>,
                                response: Response<UsuarioLoginRespose>
                            ) {
                                Log.d("api", "DEU CERTO")
                                if (response.isSuccessful) {
                                    val usuarioResponse = response.body()
                                    if (usuarioResponse != null){
                                        usuarioLoginResponse = usuarioLoginResponse.copy(
                                            userId = usuarioResponse.userId,
                                            nome = usuarioResponse.nome,
                                            email = usuarioResponse.email,
                                            role = usuarioResponse.role,
                                            token = usuarioResponse.token,
                                            nomeCompleto = usuarioResponse.nomeCompleto,
                                            cpf =usuarioResponse.cpf,
                                            dataNasc = usuarioResponse.dataNasc,
                                            descricao = usuarioResponse.descricao,
                                            imgUsuario = usuarioResponse.imgUsuario,
                                            senha = usuarioResponse.senha,
                                            listItens = usuarioResponse.listItens,
                                            cliente = usuarioResponse.cliente,
                                            parceiro = usuarioResponse.parceiro
                                        )

                                        val home = Intent(contexto, Home::class.java)
                                        home.putExtra("userToken", usuarioLoginResponse.token)
                                        home.putExtra("dataUser", usuarioLoginResponse)
                                        contexto.startActivity(home)

                                    }
                                } else {
                                    print("Erro ao tentar executar a função")
                                }
                            }
                            override fun onFailure(call: Call<UsuarioLoginRespose>, t: Throwable) {
                                Log.d("api", "ERRO")
                            }
                        })





                    },
                    modifier = Modifier
                        .padding(start = 60.dp, end = 60.dp)
                        .width(200.dp),
                    colors = ButtonDefaults.buttonColors(colorResource(R.color.rosa_escuro))
                ) {
                    Text("Entrar", color = colorResource(R.color.branco), fontSize=16.sp)
                }
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





