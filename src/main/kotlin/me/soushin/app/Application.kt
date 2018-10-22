package me.soushin.app

import app.grpc.server.gen.echo.EchoMessage
import app.grpc.server.gen.echo.EchoServiceGrpc
import io.grpc.Server
import io.grpc.ServerBuilder
import io.grpc.stub.StreamObserver

class Application {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            GrpcServer.run()
        }
    }

}

class EchoServer : EchoServiceGrpc.EchoServiceImplBase() {
    override fun echoService(request: EchoMessage?, responseObserver: StreamObserver<EchoMessage>?) {
        EchoMessage.newBuilder().apply {
            message = request?.message
        }.build().let {
            responseObserver?.apply {
                onNext(it)
                onCompleted()
            }
        }
    }
}

class GrpcServer {

    lateinit var server: Server

    fun start() {
        server = ServerBuilder.forPort(8080).apply {
            addService(EchoServer())
        }.build().start()

        Runtime.getRuntime().addShutdownHook(object : Thread() {
            override fun run() {
                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
                System.err.println("*** shutting down gRPC server since JVM is shutting down")
                this@GrpcServer.stop()
                System.err.println("*** server shut down")
            }
        })
    }

    private fun stop() {
        server.shutdown()
    }

    private fun blockUntilShutdown() {
        server.awaitTermination()
    }

    companion object {
        fun run() {
            val server = GrpcServer()
            server.start()
            server.blockUntilShutdown()
        }
    }
}

