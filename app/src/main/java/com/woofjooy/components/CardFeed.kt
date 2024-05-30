package com.woofjooy.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.woofjooy.R
import com.woofjooy.client.RetrofitService
import com.woofjooy.datas.Item
import com.woofjooy.datas.Parceiro
import com.woofjooy.datas.Servico
import com.woofjooy.datas.ParceiroFeed
import com.woofjooy.datas.ParceiroPerfil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


@Composable
fun Card(id:Int?) {
    val boxId = remember { mutableStateOf(id!!) }
    val parceiro = Parceiro()
    Box(
        modifier = Modifier
            .background(
                colorResource(R.color.rosa_claro),
                shape = RoundedCornerShape(40.dp)
            )
            .size(350.dp, 120.dp)
            .clickable {


            }
    ) {

    }
}