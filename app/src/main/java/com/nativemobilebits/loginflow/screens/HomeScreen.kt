package com.nativemobilebits.loginflow.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope

import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.nativemobilebits.loginflow.R
import com.nativemobilebits.loginflow.components.AppToolbar
import com.nativemobilebits.loginflow.components.NavigationDrawerBody
import com.nativemobilebits.loginflow.components.NavigationDrawerHeader
import com.nativemobilebits.loginflow.data.home.HomeViewModel
import com.nativemobilebits.loginflow.data.signup.SignupViewModel
import kotlinx.coroutines.launch

import android.annotation.SuppressLint
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.ui.Alignment

import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush

import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import java.text.SimpleDateFormat
import java.util.*
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LibraryBooks
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.*

import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.*

import com.nativemobilebits.loginflow.navigation.PostOfficeAppRouter
import com.nativemobilebits.loginflow.navigation.Screen
import kotlinx.coroutines.launch



@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun HomeScreen(homeViewModel: HomeViewModel = viewModel()) {

    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    val list = listOf(
        "Don’t let what you cannot do interfere with what you can do.",
        "Make each day your masterpiece.",
        "Arise, awake, and stop not till the goal is reached",
        "Life is not a problem to be solved, but a reality to be experienced.",
        "Be a warrior not a worrier",
        "You do not find the happy life. You make it.",
        "The most wasted of days is one without laughter",
        "Happiness is not by chance, but by choice",
        "Impossible is for the unwilling",
        "Don’t let yesterday take up too much of today",
        "Nothing is impossible. The word itself says “I’m possible!"
    )
    val randomElement = list.random()
    val handler = LocalUriHandler.current
    homeViewModel.getUserData()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            AppToolbar(toolbarTitle = stringResource(id = R.string.home),
                logoutButtonClicked = {
                    homeViewModel.logout()
                },
                navigationIconClicked = {
                    coroutineScope.launch {
                        scaffoldState.drawerState.open()
                    }
                }
            )
        },
        drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
        drawerContent = {
            NavigationDrawerHeader(homeViewModel.emailId.value)
            NavigationDrawerBody(navigationDrawerItems = homeViewModel.navigationItemsList,
                onNavigationItemClicked = {
                    Log.d("ComingHere", "inside_NavigationItemClicked")
                    Log.d("ComingHere", "${it.itemId} ${it.title}")
                })
        }

    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = null,
            modifier = Modifier
                .padding(top = 0.dp)
                .fillMaxHeight()
                .fillMaxWidth(),
            /*.background(
            Color.White
        )*/
            contentScale = ContentScale.FillBounds,

            )

        val gradient =
            Brush.horizontalGradient(
                listOf(
                    Color(0xFF008EFF),
                    Color(0xFFFFFFFF)
                )
            )

        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxHeight()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
            ) {
                Box(
                    modifier = Modifier
                        .width(100.dp)
                        .padding(top = 20.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = null,
                        //alignment = Alignment.BottomStart,
                        modifier = Modifier
                            //.background(color = Color.White)
                            // .padding(top = 20.dp, bottom = 20.dp, start = 0.dp, end = 240.dp)
                            // .fillMaxWidth()
                            // .height(150.dp).width(120.dp)
                            .clickable { PostOfficeAppRouter.navigateTo(Screen.HomeScreen) }


                    )

                }

                Box(modifier = Modifier.fillMaxWidth()) {
                    Column() {
                        Row(modifier = Modifier.fillMaxWidth()) {
                            Box(modifier = Modifier.weight(7f)) {


                                Text(
                                    text = " Hello Bhavanite,",
                                    modifier = Modifier.padding(top = 10.dp),
                                    color = Color.White,
                                    fontSize = 25.sp,

                                    )
                            }
                            Box(modifier = Modifier.weight(2f)) {
                                Image(
                                    painter = painterResource(id = R.drawable.ic_launcher_background),
                                    contentDescription = null,
                                    // alignment = Alignment.TopEnd,
                                    modifier = Modifier
                                        //.background(color = Color.White)
                                        .padding(top = 10.dp, end = 5.dp)
                                        // .fillMaxWidth()
                                        .height(35.dp)
                                        .width(60.dp)
                                        .clickable { PostOfficeAppRouter.navigateTo(Screen.HomeScreen) }


                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            text = randomElement,
                            modifier = Modifier.padding(start = 10.dp, top = 0.dp, end = 15.dp),
                            color = Color.White,
                            fontSize = 17.sp,


                            )


                    }
                }


            }
            /*
        Box(modifier = Modifier.fillMaxWidth()) {



            Text(
                text = " Hello Bhavanite,",
                modifier = Modifier.padding(start = 160.dp, top = 29.dp),
                color = Color.White,
                fontSize = 25.sp,
                fontFamily = homefont
            )

            Text(
                text = randomElement,
                modifier = Modifier.padding(start = 170.dp, top = 80.dp,end=15.dp),
                color = Color.White,
                fontSize = 17.sp,
                fontFamily = homefont,

                )

            Image(
                painter = painterResource(id = R.drawable.logohome),
                contentDescription = null,
                //alignment = Alignment.BottomStart,
                modifier = Modifier
                    //.background(color = Color.White)
                    .padding(top = 20.dp, bottom = 20.dp, start = 0.dp, end = 240.dp)
                    .fillMaxWidth()
                    .clickable { navController.navigate(Screen.website.route) }


            )


        }

         */
            Box(modifier = Modifier.height(0.dp)) {


            }

            Column(
                verticalArrangement = Arrangement.spacedBy(5.dp),
                modifier = Modifier.fillMaxHeight()
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {

                    GradientB1(
                        gradient = gradient,
                        onClick = { PostOfficeAppRouter.navigateTo(Screen.HomeScreen) },
                        text = "Placements",
                        img = painterResource(id = R.drawable.ic_launcher_background)
                    )
                    GradientB1(
                        gradient = gradient,
                        onClick = { PostOfficeAppRouter.navigateTo(Screen.HomeScreen) },
                        text = "Navigation",
                        img = painterResource(id = R.drawable.ic_launcher_background)
                    )


                }

                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {

                    GradientB1(
                        gradient = gradient,
                        onClick = { PostOfficeAppRouter.navigateTo(Screen.HomeScreen) },
                        text = "FeePayment",
                        img = painterResource(id = R.drawable.ic_launcher_background)
                    )
                    GradientB1(
                        gradient = gradient,
                        onClick = { PostOfficeAppRouter.navigateTo(Screen.HomeScreen) },
                        text = "Anti-Ragging",
                        img = painterResource(id = R.drawable.ic_launcher_background)
                    )


                }

                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {

                    GradientB1(
                        gradient = gradient,
                        onClick = { PostOfficeAppRouter.navigateTo(Screen.HomeScreen) },
                        text = "Alumni",
                        img = painterResource(id = R.drawable.ic_launcher_background)
                    )
                    GradientB1(
                        gradient = gradient,
                        onClick = { PostOfficeAppRouter.navigateTo(Screen.HomeScreen) },
                        text = "FeedBack",
                        img = painterResource(id = R.drawable.ic_launcher_background)
                    )

                }
                Box(modifier = Modifier.height(5.dp)) {

                }
            }
            Spacer(modifier = Modifier.height(60.dp))

        }



        @Composable
        fun GradientEdge(
            startColor: Color, endColor: Color,
        ) {
            Box(
                modifier = Modifier
                    .width(10.dp)
                    .fillMaxHeight()
                    .background(
                        brush = Brush.horizontalGradient(
                            0f to startColor, 1f to endColor,
                        )
                    )
            )
        }


        @ExperimentalAnimationApi
        @Composable
        fun GradientB1(
            gradient: Brush,
            onClick: () -> Unit,
            text: String,
            img: Painter
        ) {
            Button(

                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                contentPadding = PaddingValues(),

                modifier = Modifier
                    //.padding(150.dp)
                    .padding(top = 30.dp, start = 10.dp, end = 10.dp, bottom = 30.dp)
                    .height(100.dp)
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(20.dp))
                    //.fillMaxSize()
                    //.padding(horizontal = 1.dp, vertical = 8.dp)
                    .background(gradient),


                onClick = onClick
            ) {
                Column() {
                    Image(
                        //painterResource(id = R.drawable.exam),
                        painter = img,
                        contentDescription = "Cart button icon",
                        alignment = Alignment.Center,
                        modifier = Modifier
                            .height(180.dp)
                            .width(180.dp)

                    )
                    Text(
                        text = text,
                        color = Color.Blue,
                        fontWeight = FontWeight.ExtraBold,

                        )
                }
            }
        }
    }
}

    @ExperimentalAnimationApi
    @Composable
    fun GradientB1(
        gradient: Brush,
        onClick: () -> Unit,
        text: String,
        img: Painter
    ) {

        Button(

            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),

            contentPadding = PaddingValues(),

            modifier = Modifier
                .shadow(
                    shape = RoundedCornerShape(20.dp),
                    elevation = 2.dp
                )
                //.padding(150.dp)
                .padding(top = 5.dp, start = 1.dp, end = 1.dp, bottom = 5.dp)
                .height(130.dp)
                .width(160.dp)
                .clip(shape = RoundedCornerShape(20.dp))
                //.fillMaxSize()
                //.padding(horizontal = 1.dp, vertical = 8.dp)
                .background(gradient),


            onClick = onClick
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    //painterResource(id = R.drawable.exam),
                    painter = img,
                    contentDescription = "Cart button icon",
                    alignment = Alignment.Center,
                    modifier = Modifier.height(80.dp).width(80.dp)

                )
                Text(
                    text = text,
                    color = Color.Black,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 15.sp
                )
            }


        }
    }


/*@ExperimentalAnimationApi
@ExperimentalPagerApi
@Composable
fun NavigationController(navController: NavHostController,startDestination: String) {
    NavHost(navController = navController, startDestination = startDestination) {

        composable(NavigationItem.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(NavigationItem.Notifications.route) {
            actscreen(navController = navController)
        }

        composable(NavigationItem.Settings.route) {
            exam(navController = navController)
        }



    }


}*/










