package com.raywenderlich.android.lab1.screens


import androidx.compose.material.*
import android.annotation.SuppressLint
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import com.raywenderlich.android.lab1.R
import com.raywenderlich.android.lab1.router.BackButtonHandler
import com.raywenderlich.android.lab1.router.FundamentalsRouter
import com.raywenderlich.android.lab1.router.Screen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun ScaffoldScreen(){

    MyScaffold()

    BackButtonHandler {
        FundamentalsRouter.navigateTo(Screen.Navigation)
    }
}


@Composable
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
fun MyScaffold(){
    val scaffoldState:ScaffoldState = rememberScaffoldState()
    val scope:CoroutineScope= rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        contentColor = colorResource (id = R.color.black),
        content = {
            MyRow()
        },
        topBar = { MyTopAppBar(scaffoldState = scaffoldState, scope =scope)},
        bottomBar = { MyBottomAppBar()},
        drawerContent = { MyColumn()}
    )
}

@Composable
fun MyTopAppBar(scaffoldState: ScaffoldState, scope: CoroutineScope)
{
  val drawerState=scaffoldState.drawerState
    TopAppBar (
        navigationIcon ={
            IconButton(
                content = {
                 Icon(
                     Icons.Default.Menu,
                     tint= Color.White,
                     contentDescription = stringResource(id = R.string.menu)
                 )
                },
                onClick = {
                    scope.launch { if(drawerState.isClosed) drawerState.open() else drawerState.close() }
                }
            )
        },
        title = {Text(text = stringResource(id = R.string.title_MyComposeApp),color=Color.White)},
    backgroundColor = colorResource(id = R.color.purple_200)
        )
}

@Composable
fun MyBottomAppBar(){
    /////////////////
}